package com.food.foodbox.infrastructure.google.feign.dto.response;

public record GoogleInfoResponse(

        String name,
        String email,
        String picture
) {}
