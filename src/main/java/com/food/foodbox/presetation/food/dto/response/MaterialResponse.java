package com.food.foodbox.presetation.food.dto.response;

import com.food.foodbox.domain.food.domain.Material;

public record MaterialResponse(
        String name,
        String purchaseLink
) {

    public static MaterialResponse from(Material material) {
        return new MaterialResponse(material.getName(), material.getPurchaseLink());
    }
}
