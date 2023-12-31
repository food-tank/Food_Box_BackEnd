package com.food.foodbox.presetation.food;

import com.food.foodbox.application.food.query.QueryRecipeListService;
import com.food.foodbox.presetation.food.dto.response.RecipeResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipe")
public class RecipeController {

    private final QueryRecipeListService queryRecipeListService;

    @GetMapping("/{food-id}")
    @Operation(summary = "레시피 조회")
    public ResponseEntity<List<RecipeResponse>> getByFood(@PathVariable(name = "food-id") Long foodId) {
        return ResponseEntity.ok(queryRecipeListService.execute(foodId));
    }
}
