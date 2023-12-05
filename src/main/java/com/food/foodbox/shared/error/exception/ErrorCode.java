package com.food.foodbox.shared.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),
    INVALID_TOKEN(403, "TOKEN-403-1", "Access with Invalid Token"),
    EXPIRED_JWT(403, "TOKEN-403-2", "Access Token Expired"),
    INTERNAL_SERVER_ERROR(500, "SERVER-500-1", "Internal Server Error"),
    FOOD_NOT_FOUND(404, "FOOD-404-1", "Food Not Found"),
    IS_NOT_WRITER(403, "WRITER-403-1", "Is Not Writer"),
    IMAGE_FAILED_SAVE(424, "IMAGE-424-1", "Image Failed Save"),
    ;

    private final int status;
    private final String code;
    private final String message;
}
