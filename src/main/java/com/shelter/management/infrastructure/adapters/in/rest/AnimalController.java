package com.shelter.management.infrastructure.adapters.in.rest;

import com.shelter.management.application.dto.*;
import com.shelter.management.application.ports.in.AnimalManagementUseCase;
import com.shelter.management.domain.enums.AnimalStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/animals")
@RequiredArgsConstructor
@Slf4j
public class AnimalController {

    private final AnimalManagementUseCase animalManagementUseCase;

    @GetMapping
    public ResponseEntity<List<AnimalDTO>> getAllAnimals() {
        log.info("GET /api/animals - Fetching all animals");
        List<AnimalDTO> animals = animalManagementUseCase.getAllAnimals();
        return ResponseEntity.ok(animals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalDTO> getAnimalById(@PathVariable Long id) {
        log.info("GET /api/animals/{} - Fetching animal by ID", id);
        try {
            AnimalDTO animal = animalManagementUseCase.getAnimalById(id);
            return ResponseEntity.ok(animal);
        } catch (RuntimeException e) {
            log.error("Animal not found with ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<AnimalDTO>> getAnimalsByStatus(@PathVariable String status) {
        log.info("GET /api/animals/status/{} - Fetching animals by status", status);
        try {
            AnimalStatus animalStatus = AnimalStatus.valueOf(status.toUpperCase());
            List<AnimalDTO> animals = animalManagementUseCase.getAnimalsByStatus(animalStatus);
            return ResponseEntity.ok(animals);
        } catch (IllegalArgumentException e) {
            log.error("Invalid status: {}", status);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<AnimalDTO>> searchAnimals(@RequestParam String q) {
        log.info("GET /api/animals/search?q={} - Searching animals", q);
        List<AnimalDTO> animals = animalManagementUseCase.searchAnimals(q);
        return ResponseEntity.ok(animals);
    }

    @PostMapping
    public ResponseEntity<AnimalDTO> createAnimal(@Valid @RequestBody CreateAnimalDTO createAnimalDTO) {
        log.info("POST /api/animals - Creating new animal: {}", createAnimalDTO.getName());
        try {
            AnimalDTO createdAnimal = animalManagementUseCase.createAnimal(createAnimalDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAnimal);
        } catch (Exception e) {
            log.error("Error creating animal: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalDTO> updateAnimal(@PathVariable Long id, 
                                                 @Valid @RequestBody UpdateAnimalDTO updateAnimalDTO) {
        log.info("PUT /api/animals/{} - Updating animal", id);
        try {
            AnimalDTO updatedAnimal = animalManagementUseCase.updateAnimal(id, updateAnimalDTO);
            return ResponseEntity.ok(updatedAnimal);
        } catch (RuntimeException e) {
            log.error("Error updating animal with ID {}: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<AnimalDTO> updateAnimalStatus(@PathVariable Long id, 
                                                       @RequestBody UpdateStatusRequest request) {
        log.info("PUT /api/animals/{}/status - Updating animal status to {}", id, request.getNewStatus());
        try {
            AnimalStatus newStatus = AnimalStatus.valueOf(request.getNewStatus().toUpperCase());
            AnimalDTO updatedAnimal = animalManagementUseCase.updateAnimalStatus(id, newStatus, request.getReason());
            return ResponseEntity.ok(updatedAnimal);
        } catch (IllegalArgumentException e) {
            log.error("Invalid status: {}", request.getNewStatus());
            return ResponseEntity.badRequest().build();
        } catch (RuntimeException e) {
            log.error("Error updating animal status for ID {}: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        log.info("DELETE /api/animals/{} - Deleting animal", id);
        try {
            animalManagementUseCase.deleteAnimal(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            log.error("Error deleting animal with ID {}: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    // DTO para request de atualização de status
    public static class UpdateStatusRequest {
        private String newStatus;
        private String reason;

        public String getNewStatus() { return newStatus; }
        public void setNewStatus(String newStatus) { this.newStatus = newStatus; }
        public String getReason() { return reason; }
        public void setReason(String reason) { this.reason = reason; }
    }
}
