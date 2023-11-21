package com.food.foodbox.presetation.food;

import com.food.foodbox.application.food.command.CreateFoodService;
import com.food.foodbox.application.food.command.DeleteFoodService;
import com.food.foodbox.application.food.command.UpdateFoodService;
import com.food.foodbox.application.food.query.QueryFoodListService;
import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.security.util.SecurityUtil;
import com.food.foodbox.presetation.food.dto.request.CreateFoodRequest;
import com.food.foodbox.presetation.food.dto.response.FoodResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodController {

    private final CreateFoodService createFoodService;
    private final DeleteFoodService deleteFoodService;
    private final UpdateFoodService updateFoodService;
    private final QueryFoodListService queryFoodListService;

    @GetMapping()
    public ResponseEntity<List<FoodResponse>> getAll() {
        return ResponseEntity.ok(queryFoodListService.execute());
    }

    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody CreateFoodRequest request) {
        User user = SecurityUtil.getCurrentUserWithLogin();
        createFoodService.execute(user, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{food-id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "food-id") Long foodId) {
        User user = SecurityUtil.getCurrentUserWithLogin();
        deleteFoodService.execute(user, foodId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{food-id}")
    public ResponseEntity<Void> update(@PathVariable(name = "food-id") Long foodId, @RequestBody CreateFoodRequest request) {
        User user = SecurityUtil.getCurrentUserWithLogin();
        updateFoodService.execute(user, foodId, request);
        return ResponseEntity.noContent().build();
    }
}
