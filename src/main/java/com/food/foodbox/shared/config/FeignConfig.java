package com.food.foodbox.shared.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "com.food.foodbox.infrastructure")
@Configuration
public class FeignConfig {

}
