package main.java.com.shelter.management.application.ports.in;

import com.shelter.management.application.dto.FoodDTO;
import com.shelter.management.application.dto.CreateFoodDTO;
import com.shelter.management.application.dto.UpdateFoodDTO;
import com.shelter.management.application.dto.CreateFoodUsageDTO;

import java.util.List;

public interface FoodManagementUseCase {
    FoodDTO createFood(CreateFoodDTO dto);
    FoodDTO updateFood(Long id, UpdateFoodDTO dto);
    List<FoodDTO> getAllFoods();
    FoodDTO getFoodById(Long id);
    List<FoodDTO> getExpiredFoods();
    List<FoodDTO> getLowStockFoods();
    void deleteFood(Long id);
    void updateFoodStock(Long id, Integer newQuantity);
    void registerFoodUsage(CreateFoodUsageDTO dto);
}
