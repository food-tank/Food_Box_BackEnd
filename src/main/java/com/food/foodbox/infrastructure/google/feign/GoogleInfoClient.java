package com.food.foodbox.infrastructure.google.feign;

import com.food.foodbox.infrastructure.google.feign.dto.response.GoogleInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "googleInfoClient", url = "https://www.googleapis.com/oauth2/v1/userinfo")
public interface GoogleInfoClient {

    @GetMapping("?access_token={TOKEN}")
    GoogleInfoResponse getUserInfo(@PathVariable("TOKEN") String token);
}