package com.shelter.management.application.services;

import com.shelter.management.application.dto.*;
import com.shelter.management.application.ports.in.AnimalManagementUseCase;
import com.shelter.management.application.ports.out.AnimalRepository;
import com.shelter.management.application.ports.out.AnimalStatusHistoryRepository;
import com.shelter.management.domain.entities.Animal;
import com.shelter.management.domain.entities.AnimalStatusHistory;
import com.shelter.management.domain.enums.AnimalStatus;
import com.shelter.management.domain.enums.AnimalSize;
import com.shelter.management.domain.enums.Gender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AnimalManagementService implements AnimalManagementUseCase {

    private final AnimalRepository animalRepository;
    private final AnimalStatusHistoryRepository statusHistoryRepository;

    @Override
    public AnimalDTO createAnimal(CreateAnimalDTO createAnimalDTO) {
        log.info("Creating new animal: {}", createAnimalDTO.getName());
        
        Animal animal = Animal.builder()
                .name(createAnimalDTO.getName())
                .species(createAnimalDTO.getSpecies())
                .breed(createAnimalDTO.getBreed())
                .age(createAnimalDTO.getAge())
                .weight(createAnimalDTO.getWeight())
                .size(createAnimalDTO.getSize() != null ? 
                    AnimalSize.valueOf(createAnimalDTO.getSize()) : null)
                .gender(createAnimalDTO.getGender() != null ? 
                    Gender.valueOf(createAnimalDTO.getGender()) : null)
                .color(createAnimalDTO.getColor())
                .foundLocation(createAnimalDTO.getFoundLocation())
                .rescueDate(createAnimalDTO.getRescueDate())
                .currentStatus(createAnimalDTO.getCurrentStatus() != null ? 
                    AnimalStatus.valueOf(createAnimalDTO.getCurrentStatus()) : AnimalStatus.QUARENTENA)
                .arrivalStatus(createAnimalDTO.getArrivalStatus() != null ? 
                    AnimalStatus.valueOf(createAnimalDTO.getArrivalStatus()) : AnimalStatus.QUARENTENA)
                .observations(createAnimalDTO.getObservations())
                .microchipped(createAnimalDTO.getMicrochipped())
                .microchipNumber(createAnimalDTO.getMicrochipNumber())
                .vaccinated(createAnimalDTO.getVaccinated())
                .sterilized(createAnimalDTO.getSterilized())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Animal savedAnimal = animalRepository.save(animal);
        
        // Criar histórico inicial
        createStatusHistory(savedAnimal.getId(), null, savedAnimal.getCurrentStatus(), "Animal criado", "Sistema");
        
        log.info("Animal created successfully with ID: {}", savedAnimal.getId());
        return mapToDTO(savedAnimal);
    }

    @Override
    public AnimalDTO updateAnimal(Long id, UpdateAnimalDTO updateAnimalDTO) {
        log.info("Updating animal with ID: {}", id);
        
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado com ID: " + id));

        if (updateAnimalDTO.getName() != null) animal.setName(updateAnimalDTO.getName());
        if (updateAnimalDTO.getBreed() != null) animal.setBreed(updateAnimalDTO.getBreed());
        if (updateAnimalDTO.getAge() != null) animal.setAge(updateAnimalDTO.getAge());
        if (updateAnimalDTO.getWeight() != null) animal.setWeight(updateAnimalDTO.getWeight());
        if (updateAnimalDTO.getSize() != null) animal.setSize(AnimalSize.valueOf(updateAnimalDTO.getSize()));
        if (updateAnimalDTO.getColor() != null) animal.setColor(updateAnimalDTO.getColor());
        if (updateAnimalDTO.getObservations() != null) animal.setObservations(updateAnimalDTO.getObservations());
        if (updateAnimalDTO.getMicrochipped() != null) animal.setMicrochipped(updateAnimalDTO.getMicrochipped());
        if (updateAnimalDTO.getMicrochipNumber() != null) animal.setMicrochipNumber(updateAnimalDTO.getMicrochipNumber());
        if (updateAnimalDTO.getVaccinated() != null) animal.setVaccinated(updateAnimalDTO.getVaccinated());
        if (updateAnimalDTO.getSterilized() != null) animal.setSterilized(updateAnimalDTO.getSterilized());
        
        animal.setUpdatedAt(LocalDateTime.now());

        Animal savedAnimal = animalRepository.save(animal);
        log.info("Animal updated successfully with ID: {}", id);
        return mapToDTO(savedAnimal);
    }

    @Override
    @Transactional(readOnly = true)
    public AnimalDTO getAnimalById(Long id) {
        log.debug("Fetching animal with ID: {}", id);
        
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado com ID: " + id));
        
        return mapToDTO(animal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AnimalDTO> getAllAnimals() {
        log.debug("Fetching all animals");
        
        return animalRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AnimalDTO> getAnimalsByStatus(AnimalStatus status) {
        log.debug("Fetching animals with status: {}", status);
        
        return animalRepository.findByCurrentStatus(status)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAnimal(Long id) {
        log.info("Deleting animal with ID: {}", id);
        
        if (!animalRepository.existsById(id)) {
            throw new RuntimeException("Animal não encontrado com ID: " + id);
        }
        
        animalRepository.deleteById(id);
        log.info("Animal deleted successfully with ID: {}", id);
    }

    @Override
    public AnimalDTO updateAnimalStatus(Long id, AnimalStatus newStatus, String reason) {
        log.info("Updating status of animal ID {} to {}", id, newStatus);
        
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado com ID: " + id));

        AnimalStatus previousStatus = animal.getCurrentStatus();
        animal.setCurrentStatus(newStatus);
        animal.setUpdatedAt(LocalDateTime.now());

        Animal savedAnimal = animalRepository.save(animal);
        
        // Criar histórico de mudança de status
        createStatusHistory(id, previousStatus, newStatus, reason, "Sistema");
        
        log.info("Animal status updated successfully for ID: {}", id);
        return mapToDTO(savedAnimal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AnimalDTO> searchAnimals(String query) {
        log.debug("Searching animals with query: {}", query);
        
        List<Animal> animals = animalRepository.findByNameContainingIgnoreCase(query);
        animals.addAll(animalRepository.findBySpeciesIgnoreCase(query));
        
        return animals.stream()
                .distinct()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private void createStatusHistory(Long animalId, AnimalStatus previousStatus, 
                                   AnimalStatus newStatus, String reason, String changedBy) {
        AnimalStatusHistory history = AnimalStatusHistory.builder()
                .animalId(animalId)
                .previousStatus(previousStatus)
                .newStatus(newStatus)
                .changeDate(LocalDateTime.now())
                .changedBy(changedBy)
                .reason(reason)
                .build();
        
        statusHistoryRepository.save(history);
    }

    private AnimalDTO mapToDTO(Animal animal) {
        return AnimalDTO.builder()
                .id(animal.getId())
                .name(animal.getName())
                .species(animal.getSpecies())
                .breed(animal.getBreed())
                .age(animal.getAge())
                .weight(animal.getWeight())
                .size(animal.getSize() != null ? animal.getSize().name() : null)
                .gender(animal.getGender() != null ? animal.getGender().name() : null)
                .color(animal.getColor())
                .foundLocation(animal.getFoundLocation())
                .rescueDate(animal.getRescueDate())
                .currentStatus(animal.getCurrentStatus() != null ? animal.getCurrentStatus().name() : null)
                .arrivalStatus(animal.getArrivalStatus() != null ? animal.getArrivalStatus().name() : null)
                .observations(animal.getObservations())
                .microchipped(animal.getMicrochipped())
                .microchipNumber(animal.getMicrochipNumber())
                .vaccinated(animal.getVaccinated())
                .sterilized(animal.getSterilized())
                .createdAt(animal.getCreatedAt())
                .updatedAt(animal.getUpdatedAt())
                .build();
    }
}
