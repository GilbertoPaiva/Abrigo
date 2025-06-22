package com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.domain.entities.FoodUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SpringDataFoodUsageRepository extends JpaRepository<FoodUsage, Long> {
    
    List<FoodUsage> findByFoodId(Long foodId);
    
    List<FoodUsage> findByAnimalId(Long animalId);
    
    List<FoodUsage> findByUsageDateBetween(LocalDate startDate, LocalDate endDate);
}
