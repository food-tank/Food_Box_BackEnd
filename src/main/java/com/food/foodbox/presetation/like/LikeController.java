package com.food.foodbox.presetation.like;

import com.food.foodbox.application.like.command.CreateLikeService;
import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.security.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikeController {

    private final CreateLikeService createLikeService;

    @PostMapping("/{food-id}")
    public ResponseEntity<Void> create(@PathVariable(name = "food-id") Long foodId) {
        User user = SecurityUtil.getCurrentUserWithLogin();
        createLikeService.execute(user, foodId);
        return ResponseEntity.noContent().build();
    }
}
