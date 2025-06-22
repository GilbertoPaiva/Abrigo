package main.java.com.shelter.management.application.ports.out;

import com.shelter.management.domain.entities.MedicalRecord;

import java.util.List;
import java.util.Optional;

public interface MedicalRecordRepository {
    MedicalRecord save(MedicalRecord medicalRecord);
    Optional<MedicalRecord> findById(Long id);
    List<MedicalRecord> findAll();
    List<MedicalRecord> findByAnimalId(Long animalId);
    void deleteById(Long id);
}
