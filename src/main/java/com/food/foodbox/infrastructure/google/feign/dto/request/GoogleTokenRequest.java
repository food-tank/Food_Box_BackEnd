package com.food.foodbox.infrastructure.google.feign.dto.request;

import lombok.Builder;

@Builder
public record GoogleTokenRequest(
        String code,
        String clientId,
        String clientSecret,
        String redirectUri,
        String grantType
) {}
