package com.shelter.management.application.ports.out;

import com.shelter.management.domain.entities.AnimalStatusHistory;
import com.shelter.management.domain.enums.AnimalStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AnimalStatusHistoryRepository {
    AnimalStatusHistory save(AnimalStatusHistory statusHistory);
    Optional<AnimalStatusHistory> findById(Long id);
    List<AnimalStatusHistory> findAll();
    List<AnimalStatusHistory> findByAnimalId(Long animalId);
    List<AnimalStatusHistory> findByAnimalIdOrderByChangeDateDesc(Long animalId);
    List<AnimalStatusHistory> findByNewStatus(AnimalStatus status);
    List<AnimalStatusHistory> findByChangeDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    void deleteById(Long id);
}
