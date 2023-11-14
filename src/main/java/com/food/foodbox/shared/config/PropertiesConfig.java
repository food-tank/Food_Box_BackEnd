package com.food.foodbox.shared.config;

import com.food.foodbox.shared.config.properties.AuthProperties;
import com.food.foodbox.infrastructure.jwt.properties.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        JwtProperties.class,
        AuthProperties.class
})
public class PropertiesConfig {
}