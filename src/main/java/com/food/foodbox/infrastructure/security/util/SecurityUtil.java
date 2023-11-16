package com.food.foodbox.infrastructure.security.util;

import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.security.auth.AuthDetails;
import com.food.foodbox.shared.error.exception.ErrorCode;
import com.food.foodbox.shared.error.exception.FoodBoxException;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class SecurityUtil {
    public static User getCurrentUserWithLogin() {
        try {
            return getUser();
        } catch (ClassCastException e) {
            throw new FoodBoxException(ErrorCode.USER_NOT_FOUND);
        }
    }

    public static User getCurrentUserOrNotLogin() {
        try {
            return getUser();
        } catch (Exception e) {
            return null;
        }
    }

    public static Optional<User> getOptUser() {
        return Optional.ofNullable(getCurrentUserOrNotLogin());
    }

    private static User getUser() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        if (principal instanceof String) {
            throw new FoodBoxException(ErrorCode.USER_NOT_FOUND);
        }

        AuthDetails authDetails = (AuthDetails) principal;

        return authDetails.getUser();
    }
}
