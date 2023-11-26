package com.food.foodbox.presetation.food.dto.request;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.domain.food.domain.Material;
import com.food.foodbox.domain.food.domain.Recipe;
import com.food.foodbox.domain.food.domain.type.Difficulty;
import com.food.foodbox.domain.food.domain.type.Type;
import com.food.foodbox.domain.user.domain.User;

import java.util.List;

public record CreateFoodRequest(
        String name,
        Integer serving,
        String cookingTime,
        String content,
        String imgUrl,
        Difficulty difficulty,
        Type type,
        List<CreateMaterialRequest> materials,
        List<CreateRecipeRequest> recipes
) {
    public Food toEntity(User user) {
        return Food.builder()
                .name(name)
                .serving(serving)
                .cookingTime(cookingTime)
                .content(content)
                .imgUrl(imgUrl)
                .difficulty(difficulty)
                .type(type)
                .writerId(user.getId())
                .build();
    }

    public List<Material> toMaterialEntities(Food food) {
        return materials.stream()
                .map(material -> new Material(material.name(), material.purchaseLink(), food))
                .toList();
    }

    public List<Recipe> toRecipeEntities(Food food) {
        return recipes.stream()
                .map(recipe -> new Recipe(recipe.title(), recipe.content(), recipe.imgUrl(), food))
                .toList();
    }
}
