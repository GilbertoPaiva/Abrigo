package main.java.com.shelter.management.application.ports.in;

import com.shelter.management.application.dto.AnimalDTO;
import com.shelter.management.application.dto.CreateAnimalDTO;
import com.shelter.management.application.dto.UpdateAnimalDTO;
import com.shelter.management.domain.enums.AnimalStatus;

import java.util.List;

public interface AnimalManagementUseCase {
    AnimalDTO createAnimal(CreateAnimalDTO createAnimalDTO);
    AnimalDTO updateAnimal(Long id, UpdateAnimalDTO updateAnimalDTO);
    AnimalDTO getAnimalById(Long id);
    List<AnimalDTO> getAllAnimals();
    List<AnimalDTO> getAnimalsByStatus(AnimalStatus status);
    void deleteAnimal(Long id);
    AnimalDTO updateAnimalStatus(Long id, AnimalStatus newStatus, String reason);
    List<AnimalDTO> searchAnimals(String query);
}
