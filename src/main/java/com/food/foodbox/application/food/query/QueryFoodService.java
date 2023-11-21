package com.food.foodbox.application.food.query;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.persistence.food.FoodRepository;
import com.food.foodbox.infrastructure.persistence.user.UserRepository;
import com.food.foodbox.presetation.food.dto.response.FoodInfoResponse;
import com.food.foodbox.shared.aunnotation.QueryService;
import lombok.RequiredArgsConstructor;

@QueryService
@RequiredArgsConstructor
public class QueryFoodService {

    private final FoodRepository foodRepository;
    private final UserRepository userRepository;

    public FoodInfoResponse execute(Long foodId) {
        Food food = foodRepository.getById(foodId);
        User writer = userRepository.getById(food.getWriterId());
        return FoodInfoResponse.of(food, writer);
    }
}
