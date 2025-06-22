package com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.application.ports.out.FoodRepository;
import com.shelter.management.domain.entities.Food;
import com.shelter.management.domain.enums.AnimalType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FoodJpaAdapter implements FoodRepository {

    private final SpringDataFoodRepository repository;

    @Override
    public Food save(Food food) {
        return repository.save(food);
    }

    @Override
    public Optional<Food> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Food> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Food> findByExpirationDateBefore(LocalDate date) {
        return repository.findByExpirationDateBefore(date);
    }

    @Override
    public List<Food> findByStockQuantityLessThanMinimumStock() {
        return repository.findByStockQuantityLessThanMinimumStock();
    }

    @Override
    public List<Food> findByTargetAnimal(AnimalType targetAnimal) {
        return repository.findByTargetAnimal(targetAnimal);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
