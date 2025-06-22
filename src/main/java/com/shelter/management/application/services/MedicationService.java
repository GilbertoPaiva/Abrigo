package com.shelter.management.application.services;

import com.shelter.management.application.dto.*;
import com.shelter.management.application.ports.in.MedicationUseCase;
import com.shelter.management.application.ports.out.MedicationRepository;
import com.shelter.management.domain.entities.Medication;
import com.shelter.management.domain.enums.MedicationType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MedicationService implements MedicationUseCase {

    private final MedicationRepository medicationRepository;

    @Override
    public MedicationDTO createMedication(CreateMedicationDTO dto) {
        log.info("Creating new medication: {}", dto.getName());
        
        Medication medication = Medication.builder()
                .name(dto.getName())
                .brand(dto.getBrand())
                .activeIngredient(dto.getActiveIngredient())
                .type(dto.getType() != null ? MedicationType.valueOf(dto.getType()) : null)
                .dosage(dto.getDosage())
                .administration(dto.getAdministration())
                .stockQuantity(dto.getStockQuantity() != null ? dto.getStockQuantity() : 0)
                .expirationDate(dto.getExpirationDate())
                .supplier(dto.getSupplier())
                .unitPrice(dto.getUnitPrice())
                .minimumStock(dto.getMinimumStock() != null ? dto.getMinimumStock() : 0)
                .observations(dto.getObservations())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Medication savedMedication = medicationRepository.save(medication);
        log.info("Medication created successfully with ID: {}", savedMedication.getId());
        return mapToDTO(savedMedication);
    }

    @Override
    public MedicationDTO updateMedication(Long id, UpdateMedicationDTO dto) {
        log.info("Updating medication with ID: {}", id);
        
        Medication medication = medicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicamento não encontrado com ID: " + id));

        if (dto.getName() != null) medication.setName(dto.getName());
        if (dto.getBrand() != null) medication.setBrand(dto.getBrand());
        if (dto.getActiveIngredient() != null) medication.setActiveIngredient(dto.getActiveIngredient());
        if (dto.getType() != null) medication.setType(MedicationType.valueOf(dto.getType()));
        if (dto.getDosage() != null) medication.setDosage(dto.getDosage());
        if (dto.getAdministration() != null) medication.setAdministration(dto.getAdministration());
        if (dto.getExpirationDate() != null) medication.setExpirationDate(dto.getExpirationDate());
        if (dto.getSupplier() != null) medication.setSupplier(dto.getSupplier());
        if (dto.getUnitPrice() != null) medication.setUnitPrice(dto.getUnitPrice());
        if (dto.getMinimumStock() != null) medication.setMinimumStock(dto.getMinimumStock());
        if (dto.getObservations() != null) medication.setObservations(dto.getObservations());
        
        medication.setUpdatedAt(LocalDateTime.now());

        Medication savedMedication = medicationRepository.save(medication);
        log.info("Medication updated successfully with ID: {}", id);
        return mapToDTO(savedMedication);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicationDTO> getAllMedications() {
        log.debug("Fetching all medications");
        
        return medicationRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public MedicationDTO getMedicationById(Long id) {
        log.debug("Fetching medication with ID: {}", id);
        
        Medication medication = medicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicamento não encontrado com ID: " + id));
        
        return mapToDTO(medication);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicationDTO> getExpiredMedications() {
        log.debug("Fetching expired medications");
        
        return medicationRepository.findByExpirationDateBefore(LocalDate.now())
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicationDTO> getLowStockMedications() {
        log.debug("Fetching low stock medications");
        
        return medicationRepository.findByStockQuantityLessThanMinimumStock()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMedication(Long id) {
        log.info("Deleting medication with ID: {}", id);
        
        if (!medicationRepository.findById(id).isPresent()) {
            throw new RuntimeException("Medicamento não encontrado com ID: " + id);
        }
        
        medicationRepository.deleteById(id);
        log.info("Medication deleted successfully with ID: {}", id);
    }

    @Override
    public void updateMedicationStock(Long id, Integer newQuantity) {
        log.info("Updating stock for medication ID {} to {}", id, newQuantity);
        
        Medication medication = medicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicamento não encontrado com ID: " + id));

        medication.setStockQuantity(newQuantity);
        medication.setUpdatedAt(LocalDateTime.now());

        medicationRepository.save(medication);
        log.info("Medication stock updated successfully for ID: {}", id);
    }

    private MedicationDTO mapToDTO(Medication medication) {
        return MedicationDTO.builder()
                .id(medication.getId())
                .name(medication.getName())
                .brand(medication.getBrand())
                .activeIngredient(medication.getActiveIngredient())
                .type(medication.getType() != null ? medication.getType().name() : null)
                .dosage(medication.getDosage())
                .administration(medication.getAdministration())
                .stockQuantity(medication.getStockQuantity())
                .expirationDate(medication.getExpirationDate())
                .supplier(medication.getSupplier())
                .unitPrice(medication.getUnitPrice())
                .minimumStock(medication.getMinimumStock())
                .observations(medication.getObservations())
                .expired(medication.getExpirationDate() != null && 
                        medication.getExpirationDate().isBefore(LocalDate.now()))
                .lowStock(medication.getStockQuantity() < medication.getMinimumStock())
                .build();
    }
}
