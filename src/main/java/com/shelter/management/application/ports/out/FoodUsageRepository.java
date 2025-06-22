package com.shelter.management.application.ports.out;

import com.shelter.management.domain.entities.FoodUsage;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FoodUsageRepository {
    FoodUsage save(FoodUsage foodUsage);
    Optional<FoodUsage> findById(Long id);
    List<FoodUsage> findAll();
    List<FoodUsage> findByFoodId(Long foodId);
    List<FoodUsage> findByAnimalId(Long animalId);
    List<FoodUsage> findByUsageDateBetween(LocalDate startDate, LocalDate endDate);
    void deleteById(Long id);
}
