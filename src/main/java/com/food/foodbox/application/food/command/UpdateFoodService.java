package com.food.foodbox.application.food.command;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.persistence.food.FoodRepository;
import com.food.foodbox.infrastructure.persistence.food.MaterialRepository;
import com.food.foodbox.infrastructure.persistence.food.RecipeRepository;
import com.food.foodbox.presetation.food.dto.request.CreateFoodRequest;
import com.food.foodbox.shared.aunnotation.CommandService;
import lombok.RequiredArgsConstructor;

@CommandService
@RequiredArgsConstructor
public class UpdateFoodService {

    private final FoodRepository foodRepository;
    private final MaterialRepository materialRepository;
    private final RecipeRepository recipeRepository;

    public void execute(User user, Long foodId, CreateFoodRequest request) {
        Food food = foodRepository.getById(foodId);

        food.validateWriter(user);

        food.update(request);
        updateOthers(food, request);
    }

    private void updateOthers(Food food, CreateFoodRequest request) {
        materialRepository.deleteByFood(food);
        recipeRepository.deleteByFood(food);
        materialRepository.saveAll(request.toMaterialEntities(food));
        recipeRepository.saveAll(request.toRecipeEntities(food));
    }
}