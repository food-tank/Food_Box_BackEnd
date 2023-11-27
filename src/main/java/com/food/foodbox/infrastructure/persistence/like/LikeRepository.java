package com.food.foodbox.infrastructure.persistence.like;

import com.food.foodbox.domain.like.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    void deleteByUserIdAndFoodId(Long userId, Long foodId);
}
