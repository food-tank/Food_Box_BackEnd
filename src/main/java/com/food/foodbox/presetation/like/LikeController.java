package com.food.foodbox.presetation.like;

import com.food.foodbox.application.like.command.CreateLikeService;
import com.food.foodbox.application.like.command.DeleteLikeService;
import com.food.foodbox.application.like.query.CheckLikeService;
import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.security.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikeController {

    private final CreateLikeService createLikeService;
    private final DeleteLikeService deleteLikeService;
    private final CheckLikeService checkLikeService;

    @PostMapping("/{food-id}")
    public ResponseEntity<Void> create(@PathVariable(name = "food-id") Long foodId) {
        User user = SecurityUtil.getCurrentUserWithLogin();
        createLikeService.execute(user, foodId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{food-id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "food-id") Long foodId) {
        User user = SecurityUtil.getCurrentUserWithLogin();
        deleteLikeService.execute(user, foodId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{food-id}")
    public ResponseEntity<Boolean> check(@PathVariable(name = "food-id") Long foodId) {
        User user = SecurityUtil.getCurrentUserWithLogin();
        return ResponseEntity.ok(checkLikeService.execute(user, foodId));
    }
}
