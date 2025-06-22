package main.java.com.shelter.management.application.ports.in;

import com.shelter.management.application.dto.MedicationDTO;
import com.shelter.management.application.dto.CreateMedicationDTO;
import com.shelter.management.application.dto.UpdateMedicationDTO;

import java.util.List;

public interface MedicationUseCase {
    MedicationDTO createMedication(CreateMedicationDTO dto);
    MedicationDTO updateMedication(Long id, UpdateMedicationDTO dto);
    List<MedicationDTO> getAllMedications();
    MedicationDTO getMedicationById(Long id);
    List<MedicationDTO> getExpiredMedications();
    List<MedicationDTO> getLowStockMedications();
    void deleteMedication(Long id);
    void updateMedicationStock(Long id, Integer newQuantity);
}
