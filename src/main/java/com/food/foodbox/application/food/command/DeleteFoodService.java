package com.food.foodbox.application.food.command;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.persistence.food.FoodRepository;
import com.food.foodbox.infrastructure.persistence.food.MaterialRepository;
import com.food.foodbox.infrastructure.persistence.food.RecipeRepository;
import com.food.foodbox.shared.aunnotation.CommandService;
import lombok.RequiredArgsConstructor;

@CommandService
@RequiredArgsConstructor
public class DeleteFoodService {

    private final FoodRepository foodRepository;
    private final MaterialRepository materialRepository;
    private final RecipeRepository recipeRepository;

    public void execute(User user, Long foodId) {
        Food food = foodRepository.getById(foodId);

        food.validateWriter(user);

        foodRepository.delete(food);
        materialRepository.deleteByFood(food);
        recipeRepository.deleteByFood(food);
    }
}
