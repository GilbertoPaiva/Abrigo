package main.java.com.shelter.management.application.ports.in;

import com.shelter.management.application.dto.MedicalRecordDTO;
import com.shelter.management.application.dto.CreateMedicalRecordDTO;
import com.shelter.management.application.dto.UpdateMedicalRecordDTO;

import java.util.List;

public interface MedicalRecordUseCase {
    MedicalRecordDTO createMedicalRecord(CreateMedicalRecordDTO dto);
    MedicalRecordDTO updateMedicalRecord(Long id, UpdateMedicalRecordDTO dto);
    List<MedicalRecordDTO> getAnimalMedicalHistory(Long animalId);
    MedicalRecordDTO getMedicalRecordById(Long id);
    void deleteMedicalRecord(Long id);
}
