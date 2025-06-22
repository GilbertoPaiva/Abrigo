package com.shelter.management.infrastructure.adapters.out.persistence;

import com.shelter.management.application.ports.out.FoodUsageRepository;
import com.shelter.management.domain.entities.FoodUsage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FoodUsageJpaAdapter implements FoodUsageRepository {

    private final SpringDataFoodUsageRepository repository;

    @Override
    public FoodUsage save(FoodUsage foodUsage) {
        return repository.save(foodUsage);
    }

    @Override
    public Optional<FoodUsage> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<FoodUsage> findAll() {
        return repository.findAll();
    }

    @Override
    public List<FoodUsage> findByFoodId(Long foodId) {
        return repository.findByFoodId(foodId);
    }

    @Override
    public List<FoodUsage> findByAnimalId(Long animalId) {
        return repository.findByAnimalId(animalId);
    }

    @Override
    public List<FoodUsage> findByUsageDateBetween(LocalDate startDate, LocalDate endDate) {
        return repository.findByUsageDateBetween(startDate, endDate);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
