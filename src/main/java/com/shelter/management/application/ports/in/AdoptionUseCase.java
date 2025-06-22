package main.java.com.shelter.management.application.ports.in;

import com.shelter.management.application.dto.AdoptionDTO;
import com.shelter.management.application.dto.CreateAdoptionDTO;
import com.shelter.management.application.dto.UpdateAdoptionDTO;
import com.shelter.management.domain.enums.AdoptionStatus;

import java.util.List;

public interface AdoptionUseCase {
    AdoptionDTO createAdoption(CreateAdoptionDTO dto);
    AdoptionDTO updateAdoption(Long id, UpdateAdoptionDTO dto);
    List<AdoptionDTO> getAllAdoptions();
    AdoptionDTO getAdoptionById(Long id);
    List<AdoptionDTO> getAdoptionsByStatus(AdoptionStatus status);
    AdoptionDTO approveAdoption(Long id);
    AdoptionDTO rejectAdoption(Long id, String reason);
    void deleteAdoption(Long id);
}
