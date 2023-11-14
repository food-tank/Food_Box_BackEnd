package com.food.foodbox.domain.user.domain;

import com.food.foodbox.domain.user.domain.type.Authority;
import com.food.foodbox.infrastructure.google.feign.dto.response.GoogleInfoResponse;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String email;

    private String name;

    private String introduce;

    private String imgUrl;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public User(String email, String name, String introduce, String imgUrl, Authority authority) {
        this.email = email;
        this.name = name;
        this.introduce = introduce;
        this.imgUrl = imgUrl;
        this.authority = authority;
    }

    public User update(GoogleInfoResponse response) {
        this.name = response.name();
        return this;
    }
}
