package com.shelter.management.application.services;

import com.shelter.management.application.dto.*;
import com.shelter.management.application.ports.in.FoodManagementUseCase;
import com.shelter.management.application.ports.out.FoodRepository;
import com.shelter.management.application.ports.out.FoodUsageRepository;
import com.shelter.management.domain.entities.Food;
import com.shelter.management.domain.entities.FoodUsage;
import com.shelter.management.domain.enums.AgeGroup;
import com.shelter.management.domain.enums.AnimalType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class FoodManagementService implements FoodManagementUseCase {

    private final FoodRepository foodRepository;
    private final FoodUsageRepository foodUsageRepository;

    @Override
    public FoodDTO createFood(CreateFoodDTO dto) {
        log.info("Creating new food: {}", dto.getName());
        
        Food food = Food.builder()
                .name(dto.getName())
                .brand(dto.getBrand())
                .targetAnimal(dto.getTargetAnimal() != null ? AnimalType.valueOf(dto.getTargetAnimal()) : null)
                .ageGroup(dto.getAgeGroup() != null ? AgeGroup.valueOf(dto.getAgeGroup()) : null)
                .flavor(dto.getFlavor())
                .packageWeight(dto.getPackageWeight())
                .stockQuantity(dto.getStockQuantity() != null ? dto.getStockQuantity() : 0)
                .expirationDate(dto.getExpirationDate())
                .supplier(dto.getSupplier())
                .unitPrice(dto.getUnitPrice())
                .minimumStock(dto.getMinimumStock() != null ? dto.getMinimumStock() : 0)
                .nutritionalInfo(dto.getNutritionalInfo())
                .observations(dto.getObservations())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Food savedFood = foodRepository.save(food);
        log.info("Food created successfully with ID: {}", savedFood.getId());
        return mapToDTO(savedFood);
    }

    @Override
    public FoodDTO updateFood(Long id, UpdateFoodDTO dto) {
        log.info("Updating food with ID: {}", id);
        
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ração não encontrada com ID: " + id));

        if (dto.getName() != null) food.setName(dto.getName());
        if (dto.getBrand() != null) food.setBrand(dto.getBrand());
        if (dto.getTargetAnimal() != null) food.setTargetAnimal(AnimalType.valueOf(dto.getTargetAnimal()));
        if (dto.getAgeGroup() != null) food.setAgeGroup(AgeGroup.valueOf(dto.getAgeGroup()));
        if (dto.getFlavor() != null) food.setFlavor(dto.getFlavor());
        if (dto.getPackageWeight() != null) food.setPackageWeight(dto.getPackageWeight());
        if (dto.getExpirationDate() != null) food.setExpirationDate(dto.getExpirationDate());
        if (dto.getSupplier() != null) food.setSupplier(dto.getSupplier());
        if (dto.getUnitPrice() != null) food.setUnitPrice(dto.getUnitPrice());
        if (dto.getMinimumStock() != null) food.setMinimumStock(dto.getMinimumStock());
        if (dto.getNutritionalInfo() != null) food.setNutritionalInfo(dto.getNutritionalInfo());
        if (dto.getObservations() != null) food.setObservations(dto.getObservations());
        
        food.setUpdatedAt(LocalDateTime.now());

        Food savedFood = foodRepository.save(food);
        log.info("Food updated successfully with ID: {}", id);
        return mapToDTO(savedFood);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FoodDTO> getAllFoods() {
        log.debug("Fetching all foods");
        
        return foodRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public FoodDTO getFoodById(Long id) {
        log.debug("Fetching food with ID: {}", id);
        
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ração não encontrada com ID: " + id));
        
        return mapToDTO(food);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FoodDTO> getExpiredFoods() {
        log.debug("Fetching expired foods");
        
        return foodRepository.findByExpirationDateBefore(LocalDate.now())
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FoodDTO> getLowStockFoods() {
        log.debug("Fetching low stock foods");
        
        return foodRepository.findByStockQuantityLessThanMinimumStock()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteFood(Long id) {
        log.info("Deleting food with ID: {}", id);
        
        if (!foodRepository.findById(id).isPresent()) {
            throw new RuntimeException("Ração não encontrada com ID: " + id);
        }
        
        foodRepository.deleteById(id);
        log.info("Food deleted successfully with ID: {}", id);
    }

    @Override
    public void updateFoodStock(Long id, Integer newQuantity) {
        log.info("Updating stock for food ID {} to {}", id, newQuantity);
        
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ração não encontrada com ID: " + id));

        food.setStockQuantity(newQuantity);
        food.setUpdatedAt(LocalDateTime.now());

        foodRepository.save(food);
        log.info("Food stock updated successfully for ID: {}", id);
    }

    @Override
    public void registerFoodUsage(CreateFoodUsageDTO dto) {
        log.info("Registering food usage for food ID: {}", dto.getFoodId());
        
        // Verificar se a ração existe
        Food food = foodRepository.findById(dto.getFoodId())
                .orElseThrow(() -> new RuntimeException("Ração não encontrada com ID: " + dto.getFoodId()));

        // Verificar se há estoque suficiente
        if (food.getStockQuantity() < dto.getQuantityUsed()) {
            throw new RuntimeException("Estoque insuficiente. Disponível: " + food.getStockQuantity());
        }

        // Registrar o uso
        FoodUsage usage = FoodUsage.builder()
                .foodId(dto.getFoodId())
                .animalId(dto.getAnimalId())
                .quantityUsed(dto.getQuantityUsed())
                .usageDate(dto.getUsageDate() != null ? dto.getUsageDate() : LocalDate.now())
                .usedBy(dto.getUsedBy())
                .observations(dto.getObservations())
                .build();

        foodUsageRepository.save(usage);

        // Atualizar estoque
        food.setStockQuantity(food.getStockQuantity() - dto.getQuantityUsed().intValue());
        food.setUpdatedAt(LocalDateTime.now());
        foodRepository.save(food);

        log.info("Food usage registered successfully");
    }

    private FoodDTO mapToDTO(Food food) {
        return FoodDTO.builder()
                .id(food.getId())
                .name(food.getName())
                .brand(food.getBrand())
                .targetAnimal(food.getTargetAnimal() != null ? food.getTargetAnimal().name() : null)
                .ageGroup(food.getAgeGroup() != null ? food.getAgeGroup().name() : null)
                .flavor(food.getFlavor())
                .packageWeight(food.getPackageWeight())
                .stockQuantity(food.getStockQuantity())
                .expirationDate(food.getExpirationDate())
                .supplier(food.getSupplier())
                .unitPrice(food.getUnitPrice())
                .minimumStock(food.getMinimumStock())
                .nutritionalInfo(food.getNutritionalInfo())
                .observations(food.getObservations())
                .expired(food.getExpirationDate() != null && 
                        food.getExpirationDate().isBefore(LocalDate.now()))
                .lowStock(food.getStockQuantity() < food.getMinimumStock())
                .build();
    }
}
