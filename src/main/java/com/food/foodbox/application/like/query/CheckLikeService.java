package com.food.foodbox.application.like.query;

import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.persistence.like.LikeRepository;
import com.food.foodbox.shared.aunnotation.QueryService;
import lombok.RequiredArgsConstructor;

@QueryService
@RequiredArgsConstructor
public class CheckLikeService {

    private final LikeRepository likeRepository;

    public Boolean execute(User user, Long foodId) {
        return likeRepository.existsByUserIdAndFoodId(user.getId(), foodId);
    }
}
