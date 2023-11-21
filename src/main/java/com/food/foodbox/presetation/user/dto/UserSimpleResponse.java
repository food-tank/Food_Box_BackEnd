package com.food.foodbox.presetation.user.dto;

import com.food.foodbox.domain.user.domain.User;

public record UserSimpleResponse(
        Long id,
        String name
) {

    public static UserSimpleResponse from(User user) {
        return new UserSimpleResponse(user.getId(), user.getName());
    }
}
