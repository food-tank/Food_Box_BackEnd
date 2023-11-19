package com.food.foodbox.presetation.food.dto.request;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.domain.food.domain.Recipe;

public record CreateRecipeRequest(
        String title,
        String content,
        String imgUrl
) {
    public Recipe toEntity(Food food) {
        return new Recipe(title, content,imgUrl, food);
    }
}
