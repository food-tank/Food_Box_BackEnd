package com.food.foodbox.application.food.query;

import com.food.foodbox.domain.food.domain.Recipe;
import com.food.foodbox.infrastructure.persistence.food.RecipeRepository;
import com.food.foodbox.presetation.food.dto.response.RecipeResponse;
import com.food.foodbox.shared.aunnotation.QueryService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@QueryService
@RequiredArgsConstructor
public class QueryRecipeListService {

    private final RecipeRepository recipeRepository;

    public List<RecipeResponse> execute(Long fooId) {
        List<Recipe> recipes = recipeRepository.findByFoodId(fooId);
        return recipes.stream()
                .map(RecipeResponse::from)
                .toList();
    }
}
