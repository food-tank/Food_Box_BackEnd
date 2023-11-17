package com.food.foodbox.infrastructure.persistence.Food;

import com.food.foodbox.domain.food.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
