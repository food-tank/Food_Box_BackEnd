package com.food.foodbox.application.food.query;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.domain.food.domain.type.Type;
import com.food.foodbox.infrastructure.persistence.food.FoodRepository;
import com.food.foodbox.infrastructure.persistence.user.UserRepository;
import com.food.foodbox.presetation.food.dto.response.FoodResponse;
import com.food.foodbox.shared.aunnotation.QueryService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@QueryService
@RequiredArgsConstructor
public class QueryRecentFoodListService {

    private final UserRepository userRepository;
    private final FoodRepository foodRepository;

    public List<FoodResponse> execute(String type) {
        System.out.println(Type.valueOf(type));
        List<Food> foods = foodRepository.findByTypeOrderByIdDesc(Type.valueOf(type));
        return foods.stream()
                .map(food -> FoodResponse.of(food, userRepository.getById(food.getWriterId())))
                .toList();
    }
}
