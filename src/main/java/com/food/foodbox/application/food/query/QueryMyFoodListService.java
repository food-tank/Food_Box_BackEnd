package com.food.foodbox.application.food.query;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.persistence.food.FoodRepository;
import com.food.foodbox.presetation.food.dto.response.FoodResponse;
import com.food.foodbox.shared.aunnotation.QueryService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@QueryService
@RequiredArgsConstructor
public class QueryMyFoodListService {

    private final FoodRepository foodRepository;

    public List<FoodResponse> execute(User user) {
        List<Food> foods = foodRepository.findByWriterId(user.getId());
        return foods.stream()
                .map(food -> FoodResponse.of(food, user, true))
                .toList();
    }
}
