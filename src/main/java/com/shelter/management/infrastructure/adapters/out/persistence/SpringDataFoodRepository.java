package com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.domain.entities.Food;
import com.shelter.management.domain.enums.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SpringDataFoodRepository extends JpaRepository<Food, Long> {
    
    List<Food> findByExpirationDateBefore(LocalDate date);
    
    @Query("SELECT f FROM Food f WHERE f.stockQuantity < f.minimumStock")
    List<Food> findByStockQuantityLessThanMinimumStock();
    
    List<Food> findByTargetAnimal(AnimalType targetAnimal);
}
