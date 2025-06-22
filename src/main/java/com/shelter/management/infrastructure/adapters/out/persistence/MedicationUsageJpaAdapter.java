package com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.application.ports.out.MedicationUsageRepository;
import com.shelter.management.domain.entities.MedicationUsage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MedicationUsageJpaAdapter implements MedicationUsageRepository {

    private final SpringDataMedicationUsageRepository repository;

    @Override
    public MedicationUsage save(MedicationUsage medicationUsage) {
        return repository.save(medicationUsage);
    }

    @Override
    public Optional<MedicationUsage> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<MedicationUsage> findAll() {
        return repository.findAll();
    }

    @Override
    public List<MedicationUsage> findByMedicalRecordId(Long medicalRecordId) {
        return repository.findByMedicalRecordId(medicalRecordId);
    }

    @Override
    public List<MedicationUsage> findByMedicationId(Long medicationId) {
        return repository.findByMedicationId(medicationId);
    }

    @Override
    public List<MedicationUsage> findByAdministrationDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return repository.findByAdministrationDateBetween(startDate, endDate);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
