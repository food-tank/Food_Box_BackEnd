package com.food.foodbox.application.user.query;

import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.persistence.user.UserRepository;
import com.food.foodbox.presetation.user.dto.response.UserResponse;
import com.food.foodbox.shared.aunnotation.QueryService;
import lombok.RequiredArgsConstructor;

@QueryService
@RequiredArgsConstructor
public class QueryUserService {

    private final UserRepository userRepository;

    public UserResponse execute(Long id) {
        User user = userRepository.getById(id);
        return UserResponse.from(user);
    }
}
