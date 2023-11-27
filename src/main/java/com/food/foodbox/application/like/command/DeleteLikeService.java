package com.food.foodbox.application.like.command;

import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.persistence.like.LikeRepository;
import com.food.foodbox.shared.aunnotation.CommandService;
import lombok.RequiredArgsConstructor;

@CommandService
@RequiredArgsConstructor
public class DeleteLikeService {

    private final LikeRepository likeRepository;

    public void execute(User user, Long foodId) {
        likeRepository.deleteByUserIdAndFoodId(user.getId(), foodId);
    }
}
