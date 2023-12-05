package com.food.foodbox.presetation.food.dto.response;

import java.util.List;

public record FoodsResponse (
    int totalCount,
    int currentPage,
    List<FoodResponse> foods
) {

    public static FoodsResponse of(int totalCount, int currentPage, List<FoodResponse> foods) {
        return new FoodsResponse(totalCount, currentPage, foods);
    }
}
