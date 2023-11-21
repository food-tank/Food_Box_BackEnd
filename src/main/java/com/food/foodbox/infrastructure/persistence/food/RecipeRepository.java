package com.food.foodbox.infrastructure.persistence.food;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.domain.food.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByFoodId(Long fooId);
    void deleteByFood(Food food);
}
