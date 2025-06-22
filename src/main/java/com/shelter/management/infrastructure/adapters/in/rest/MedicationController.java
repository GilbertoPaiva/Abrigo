package com.shelter.management.infrastructure.adapters.in.rest;

import com.shelter.management.application.dto.*;
import com.shelter.management.application.ports.in.MedicationUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/medications")
@RequiredArgsConstructor
@Slf4j
public class MedicationController {

    private final MedicationUseCase medicationUseCase;

    @GetMapping
    public ResponseEntity<List<MedicationDTO>> getAllMedications() {
        log.info("GET /api/medications - Fetching all medications");
        List<MedicationDTO> medications = medicationUseCase.getAllMedications();
        return ResponseEntity.ok(medications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicationDTO> getMedicationById(@PathVariable Long id) {
        log.info("GET /api/medications/{} - Fetching medication by ID", id);
        try {
            MedicationDTO medication = medicationUseCase.getMedicationById(id);
            return ResponseEntity.ok(medication);
        } catch (RuntimeException e) {
            log.error("Medication not found with ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/expired")
    public ResponseEntity<List<MedicationDTO>> getExpiredMedications() {
        log.info("GET /api/medications/expired - Fetching expired medications");
        List<MedicationDTO> medications = medicationUseCase.getExpiredMedications();
        return ResponseEntity.ok(medications);
    }

    @GetMapping("/low-stock")
    public ResponseEntity<List<MedicationDTO>> getLowStockMedications() {
        log.info("GET /api/medications/low-stock - Fetching low stock medications");
        List<MedicationDTO> medications = medicationUseCase.getLowStockMedications();
        return ResponseEntity.ok(medications);
    }

    @PostMapping
    public ResponseEntity<MedicationDTO> createMedication(@Valid @RequestBody CreateMedicationDTO createMedicationDTO) {
        log.info("POST /api/medications - Creating new medication: {}", createMedicationDTO.getName());
        try {
            MedicationDTO createdMedication = medicationUseCase.createMedication(createMedicationDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdMedication);
        } catch (Exception e) {
            log.error("Error creating medication: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicationDTO> updateMedication(@PathVariable Long id, 
                                                         @Valid @RequestBody UpdateMedicationDTO updateMedicationDTO) {
        log.info("PUT /api/medications/{} - Updating medication", id);
        try {
            MedicationDTO updatedMedication = medicationUseCase.updateMedication(id, updateMedicationDTO);
            return ResponseEntity.ok(updatedMedication);
        } catch (RuntimeException e) {
            log.error("Error updating medication with ID {}: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<Void> updateMedicationStock(@PathVariable Long id, 
                                                     @RequestBody UpdateStockRequest request) {
        log.info("PUT /api/medications/{}/stock - Updating medication stock to {}", id, request.getNewQuantity());
        try {
            medicationUseCase.updateMedicationStock(id, request.getNewQuantity());
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            log.error("Error updating medication stock for ID {}: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedication(@PathVariable Long id) {
        log.info("DELETE /api/medications/{} - Deleting medication", id);
        try {
            medicationUseCase.deleteMedication(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            log.error("Error deleting medication with ID {}: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    // DTO para request de atualização de estoque
    public static class UpdateStockRequest {
        private Integer newQuantity;

        public Integer getNewQuantity() { return newQuantity; }
        public void setNewQuantity(Integer newQuantity) { this.newQuantity = newQuantity; }
    }
}
