package com.food.foodbox.presetation.food.dto.request;

public record CreateRecipeRequest(
        String title,
        String content,
        String imgUrl
) {
}
