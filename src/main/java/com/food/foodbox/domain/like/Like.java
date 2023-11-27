package com.food.foodbox.domain.like;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "like_tbl")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long foodId;

    public Like(Long userId, Long foodId) {
        this.userId = userId;
        this.foodId = foodId;
    }
}
