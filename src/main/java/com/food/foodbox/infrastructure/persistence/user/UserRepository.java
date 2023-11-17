package com.food.foodbox.infrastructure.persistence.user;

import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.shared.error.exception.ErrorCode;
import com.food.foodbox.shared.error.exception.FoodBoxException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    default User getById(Long id) {
        return findById(id)
                .orElseThrow(() -> new FoodBoxException(ErrorCode.USER_NOT_FOUND));
    }
}
