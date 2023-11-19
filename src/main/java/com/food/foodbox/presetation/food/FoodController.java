package com.food.foodbox.presetation.food;

import com.food.foodbox.application.food.command.CreateFoodService;
import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.security.util.SecurityUtil;
import com.food.foodbox.presetation.food.dto.request.CreateFoodRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodController {

    private final CreateFoodService createFoodService;

    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody CreateFoodRequest request) {
        User user = SecurityUtil.getCurrentUserWithLogin();
        createFoodService.execute(user, request);
        return ResponseEntity.noContent().build();
    }
}
