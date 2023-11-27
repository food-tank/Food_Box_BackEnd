package com.food.foodbox.infrastructure.persistence.like;

import com.food.foodbox.domain.like.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByUserId(Long userId);
    Boolean existsByUserIdAndFoodId(Long userId, Long foodId);
    void deleteByUserIdAndFoodId(Long userId, Long foodId);
}
