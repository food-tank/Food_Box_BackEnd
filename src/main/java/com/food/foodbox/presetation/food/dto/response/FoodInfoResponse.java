package com.food.foodbox.presetation.food.dto.response;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.domain.food.domain.type.Difficulty;
import com.food.foodbox.domain.food.domain.type.Type;
import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.presetation.user.dto.UserSimpleResponse;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record FoodInfoResponse(
        Long foodId,
        String name,
        Integer serving,
        String cookingTime,
        String content,
        String imgUrl,
        Integer likeCount,
        Difficulty difficulty,
        Type type,
        LocalDate createTime,
        UserSimpleResponse writer
) {

    public static FoodInfoResponse of(Food food, User user) {
        return FoodInfoResponse.builder()
                .foodId(food.getId())
                .name(food.getName())
                .serving(food.getServing())
                .cookingTime(food.getCookingTime())
                .cookingTime(food.getContent())
                .imgUrl(food.getImgUrl())
                .likeCount(food.getLikeCount())
                .difficulty(food.getDifficulty())
                .type(food.getType())
                .createTime(food.getCreateTime())
                .writer(UserSimpleResponse.from(user))
                .build();
    }
}
