package com.food.foodbox.shared.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("spring.security.oauth2.client.registration.google")
public class AuthProperties {

    private String clientId;
    private String clientSecret;
    private String redirectUri;
}
