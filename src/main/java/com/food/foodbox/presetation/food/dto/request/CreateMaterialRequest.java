package com.food.foodbox.presetation.food.dto.request;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.domain.food.domain.Material;

public record CreateMaterialRequest (
        String name
) {
    public Material toEntity(Food food) {
        return new Material(name, food);
    }
}
