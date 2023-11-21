package com.food.foodbox.infrastructure.persistence.food;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.domain.food.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    void deleteByFood(Food food);
}
