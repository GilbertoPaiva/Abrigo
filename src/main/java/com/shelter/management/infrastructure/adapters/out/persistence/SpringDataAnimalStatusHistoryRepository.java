package com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.domain.entities.AnimalStatusHistory;
import com.shelter.management.domain.enums.AnimalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SpringDataAnimalStatusHistoryRepository extends JpaRepository<AnimalStatusHistory, Long> {
    
    List<AnimalStatusHistory> findByAnimalId(Long animalId);
    
    List<AnimalStatusHistory> findByAnimalIdOrderByChangeDateDesc(Long animalId);
    
    List<AnimalStatusHistory> findByNewStatus(AnimalStatus status);
    
    List<AnimalStatusHistory> findByChangeDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
