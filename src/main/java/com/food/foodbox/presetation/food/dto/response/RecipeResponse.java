package com.food.foodbox.presetation.food.dto.response;

import com.food.foodbox.domain.food.domain.Recipe;

public record RecipeResponse(
        String title,
        String content,
        String imgUrl
) {

    public static RecipeResponse from(Recipe recipe) {
        return new RecipeResponse(recipe.getTitle(), recipe.getContent(), recipe.getImgUrl());
    }
}
