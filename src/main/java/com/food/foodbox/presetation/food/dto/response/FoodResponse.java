package com.food.foodbox.presetation.food.dto.response;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.domain.food.domain.type.Type;
import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.presetation.user.dto.UserSimpleResponse;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record FoodResponse (
        Long foodId,
        String foodName,
        String imgUrl,
        Type type,
        LocalDate createTime,
        UserSimpleResponse writer
) {

    public static FoodResponse of(Food food, User user) {
        return FoodResponse.builder()
                .foodId(food.getId())
                .foodName(food.getName())
                .imgUrl(food.getImgUrl())
                .type(food.getType())
                .createTime(food.getCreateTime())
                .writer(UserSimpleResponse.from(user))
                .build();
    }
}
