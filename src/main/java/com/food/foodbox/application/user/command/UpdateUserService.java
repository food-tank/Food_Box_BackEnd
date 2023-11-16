package com.food.foodbox.application.user.command;

import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.persistence.user.UserRepository;
import com.food.foodbox.presetation.user.dto.request.UpdateUserRequest;
import com.food.foodbox.shared.aunnotation.CommandService;
import lombok.RequiredArgsConstructor;

@CommandService
@RequiredArgsConstructor
public class UpdateUserService {

    private final UserRepository userRepository;

    public void execute(User user, UpdateUserRequest request) {
        user.update(request);
        userRepository.save(user);
    }
}
