package com.food.foodbox.application.food.query;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.persistence.food.FoodRepository;
import com.food.foodbox.infrastructure.persistence.like.LikeRepository;
import com.food.foodbox.infrastructure.persistence.user.UserRepository;
import com.food.foodbox.presetation.food.dto.response.FoodResponse;
import com.food.foodbox.shared.aunnotation.QueryService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@QueryService
@RequiredArgsConstructor
public class QuerySearchFoodService {

    private final FoodRepository foodRepository;
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;

    public List<FoodResponse> execute(User user, String q) {
        List<Food> foods = foodRepository.findByNameContainsOrContentContains(q, q);
        return foods.stream()
                .map(food -> FoodResponse.of(food, userRepository.getById(food.getWriterId()), isLiked(user, food)))
                .toList();
    }

    private Boolean isLiked(User user, Food food) {
        if (user == null) {
            return false;
        }
        return likeRepository.existsByUserIdAndFoodId(user.getId(), food.getId());
    }
}
