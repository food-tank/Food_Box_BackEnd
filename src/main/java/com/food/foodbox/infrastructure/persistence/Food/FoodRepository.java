package com.food.foodbox.infrastructure.persistence.Food;

import com.food.foodbox.domain.food.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
