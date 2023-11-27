package com.food.foodbox.application.food.query;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.persistence.food.FoodRepository;
import com.food.foodbox.infrastructure.persistence.user.UserRepository;
import com.food.foodbox.presetation.food.dto.response.FoodResponse;
import com.food.foodbox.shared.aunnotation.QueryService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@QueryService
@RequiredArgsConstructor
public class QueryLikeFoodService {

    private final FoodRepository foodRepository;
    private final UserRepository userRepository;

    public List<FoodResponse> execute(User user) {
        List<Food> foods = foodRepository.findLikeProject(user);
        return foods.stream()
                .map(food -> FoodResponse.of(food, userRepository.getById(food.getWriterId()), true))
                .toList();
    }
}
