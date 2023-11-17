package com.food.foodbox.presetation.user.dto.request;

public record UpdateUserRequest (
        String name,
        String introduce,
        String imgUrl
) {
}
