package com.food.foodbox.infrastructure.google;

import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.domain.user.domain.type.Authority;
import com.food.foodbox.shared.config.properties.AuthProperties;
import com.food.foodbox.infrastructure.google.feign.GoogleAuthClient;
import com.food.foodbox.infrastructure.google.feign.GoogleInfoClient;
import com.food.foodbox.infrastructure.google.feign.dto.request.GoogleTokenRequest;
import com.food.foodbox.infrastructure.google.feign.dto.response.GoogleInfoResponse;
import com.food.foodbox.infrastructure.jwt.dto.TokenResponse;
import com.food.foodbox.infrastructure.jwt.util.JwtProvider;
import com.food.foodbox.infrastructure.persistence.user.UserRepository;
import com.food.foodbox.shared.aunnotation.CommandService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@CommandService
@RequiredArgsConstructor
public class GoogleLoginService {

    private final AuthProperties authProperties;
    private final GoogleAuthClient googleAuthClient;
    private final GoogleInfoClient googleInfoClient;
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    public TokenResponse execute(String code) {
        String googleToken = googleAuthClient.getGoogleToken(
                createRequest(code)
        ).accessToken();
        GoogleInfoResponse userInfo = googleInfoClient.getUserInfo(googleToken);
        User user = saveOrUpdate(userInfo);

        return jwtProvider.generateToken(user.getEmail(), user.getAuthority().toString());
    }

    public GoogleTokenRequest createRequest(String code) {
        return GoogleTokenRequest.builder()
                .code(code)
                .clientId(authProperties.getClientId())
                .clientSecret(authProperties.getClientSecret())
                .redirectUri(authProperties.getRedirectUri())
                .grantType("authorization_code")
                .build();
    }

    private User saveOrUpdate(GoogleInfoResponse response) {
        Optional<User> user = userRepository.findByEmail(response.email());

        if (user.isEmpty()) {
            return userRepository.save(User.builder()
                    .email(response.email())
                    .name(response.name())
                    .authority(Authority.USER)
                    .imgUrl(response.picture())
                    .build());
        }

        return user.get().update(response);
    }
}
