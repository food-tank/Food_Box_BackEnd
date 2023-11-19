package com.food.foodbox.application.food.command;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.persistence.Food.FoodRepository;
import com.food.foodbox.infrastructure.persistence.Food.MaterialRepository;
import com.food.foodbox.infrastructure.persistence.Food.RecipeRepository;
import com.food.foodbox.presetation.food.dto.request.CreateFoodRequest;
import com.food.foodbox.shared.aunnotation.CommandService;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;

@CommandService
@RequiredArgsConstructor
public class CreateFoodService {

    private final FoodRepository foodRepository;
    private final MaterialRepository materialRepository;
    private final RecipeRepository recipeRepository;

    public void execute(User user, CreateFoodRequest request) {
        Food food = foodRepository.save(request.toEntity(user));
        materialRepository.saveAll(request.materials().stream().map(r -> r.toEntity(food)).collect(Collectors.toList()));
        recipeRepository.saveAll(request.recipes().stream().map(r -> r.toEntity(food)).collect(Collectors.toList()));
    }
}
