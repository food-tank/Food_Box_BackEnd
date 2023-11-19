package com.food.foodbox.presetation.food.dto.request;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.domain.food.domain.type.Difficulty;
import com.food.foodbox.domain.user.domain.User;

import java.util.List;

public record CreateFoodRequest(
        String name,
        Integer serving,
        String cookingTime,
        String content,
        Difficulty difficulty,
        List<CreateMaterialRequest> materials,
        List<CreateRecipeRequest> recipes
) {
    public Food toEntity(User user) {
        return Food.builder()
                .name(name)
                .serving(serving)
                .cookingTime(cookingTime)
                .content(content)
                .difficulty(difficulty)
                .writerId(user.getId())
                .build();
    }
}
