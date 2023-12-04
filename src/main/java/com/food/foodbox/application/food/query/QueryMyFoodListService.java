package com.food.foodbox.application.food.query;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.persistence.food.FoodRepository;
import com.food.foodbox.infrastructure.persistence.like.LikeRepository;
import com.food.foodbox.presetation.food.dto.response.FoodResponse;
import com.food.foodbox.shared.aunnotation.QueryService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@QueryService
@RequiredArgsConstructor
public class QueryMyFoodListService {

    private final FoodRepository foodRepository;
    private final LikeRepository likeRepository;

    public List<FoodResponse> execute(User user) {
        List<Food> foods = foodRepository.findByWriterId(user.getId());
        return foods.stream()
                .map(food -> FoodResponse.of(food, user, isLiked(user, food)))
                .toList();
    }

    private Boolean isLiked(User user, Food food) {
        if (user == null) {
            return false;
        }
        return likeRepository.existsByUserIdAndFoodId(user.getId(), food.getId());
    }
}
