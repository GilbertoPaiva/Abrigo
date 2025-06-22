package com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.domain.entities.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataMedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    
    List<MedicalRecord> findByAnimalId(Long animalId);
}
