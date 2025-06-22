package com.shelter.management.application.ports.out;

import com.shelter.management.domain.entities.MedicationUsage;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MedicationUsageRepository {
    MedicationUsage save(MedicationUsage medicationUsage);
    Optional<MedicationUsage> findById(Long id);
    List<MedicationUsage> findAll();
    List<MedicationUsage> findByMedicalRecordId(Long medicalRecordId);
    List<MedicationUsage> findByMedicationId(Long medicationId);
    List<MedicationUsage> findByAdministrationDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    void deleteById(Long id);
}
