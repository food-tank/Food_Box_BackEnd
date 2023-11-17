package com.food.foodbox.presetation.user;

import com.food.foodbox.application.user.command.UpdateUserService;
import com.food.foodbox.application.user.query.QueryUserService;
import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.security.util.SecurityUtil;
import com.food.foodbox.presetation.user.dto.request.UpdateUserRequest;
import com.food.foodbox.presetation.user.dto.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final QueryUserService queryUserService;
    private final UpdateUserService updateUserService;

    @GetMapping("/{user-id}")
    @Operation(summary = "유저 조회")
    public ResponseEntity<UserResponse> getOne(@PathVariable(name = "user-id") Long id) {
        return ResponseEntity.ok(queryUserService.execute(id));
    }

    @PutMapping("")
    @Operation(summary = "유저 정보 수정")
    public ResponseEntity<Void> update(@RequestBody UpdateUserRequest request) {
        User user = SecurityUtil.getCurrentUserWithLogin();
        updateUserService.execute(user, request);
        return ResponseEntity.noContent().build();
    }
}
