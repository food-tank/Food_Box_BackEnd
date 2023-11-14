package com.food.foodbox.infrastructure.google.feign.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GoogleTokenResponse(

        @JsonProperty("access_token")
        String accessToken
) { }
