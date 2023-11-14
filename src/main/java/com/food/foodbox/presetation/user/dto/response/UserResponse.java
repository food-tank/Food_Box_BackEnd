package com.food.foodbox.presetation.user.dto.response;

import com.food.foodbox.domain.user.domain.User;
import lombok.Builder;

@Builder
public record UserResponse(
        Long id,
        String name,
        String email,
        String introduce,
        String imgUrl
) {
    public static UserResponse from(User user) {
        return UserResponse
                .builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .introduce(user.getIntroduce())
                .imgUrl(user.getImgUrl())
                .build();
    }
}
