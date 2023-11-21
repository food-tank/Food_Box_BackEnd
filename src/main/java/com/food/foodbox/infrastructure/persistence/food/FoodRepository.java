package com.food.foodbox.infrastructure.persistence.food;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.shared.error.exception.ErrorCode;
import com.food.foodbox.shared.error.exception.FoodBoxException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

    default Food getById(Long id) {
        return findById(id)
                .orElseThrow(() -> new FoodBoxException(ErrorCode.FOOD_NOT_FOUND));
    }
}
