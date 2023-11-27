package com.food.foodbox.application.like.command;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.persistence.food.FoodRepository;
import com.food.foodbox.infrastructure.persistence.like.LikeRepository;
import com.food.foodbox.shared.aunnotation.CommandService;
import lombok.RequiredArgsConstructor;

@CommandService
@RequiredArgsConstructor
public class DeleteLikeService {

    private final FoodRepository foodRepository;
    private final LikeRepository likeRepository;

    public void execute(User user, Long foodId) {
        Food food = foodRepository.getById(foodId);
        likeRepository.deleteByUserIdAndFoodId(user.getId(), food.getId());
        food.decreaseLikeCount();
    }
}
