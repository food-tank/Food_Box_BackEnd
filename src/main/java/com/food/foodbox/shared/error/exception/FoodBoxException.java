package com.food.foodbox.shared.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FoodBoxException extends RuntimeException {

    private final ErrorCode errorCode;
}
