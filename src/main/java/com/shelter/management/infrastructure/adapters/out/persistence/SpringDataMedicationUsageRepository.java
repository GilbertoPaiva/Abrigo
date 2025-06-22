package com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.domain.entities.MedicationUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SpringDataMedicationUsageRepository extends JpaRepository<MedicationUsage, Long> {
    
    List<MedicationUsage> findByMedicalRecordId(Long medicalRecordId);
    
    List<MedicationUsage> findByMedicationId(Long medicationId);
    
    List<MedicationUsage> findByAdministrationDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
