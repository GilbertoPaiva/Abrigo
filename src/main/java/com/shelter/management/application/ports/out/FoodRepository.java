package com.shelter.management.application.ports.out;

import com.shelter.management.domain.entities.Food;
import com.shelter.management.domain.enums.AnimalType;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FoodRepository {
    Food save(Food food);
    Optional<Food> findById(Long id);
    List<Food> findAll();
    List<Food> findByExpirationDateBefore(LocalDate date);
    List<Food> findByStockQuantityLessThanMinimumStock();
    List<Food> findByTargetAnimal(AnimalType targetAnimal);
    void deleteById(Long id);
}
