package com.food.foodbox.domain.food.domain;

import com.food.foodbox.domain.food.domain.type.Difficulty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false)
    private Integer serving;

    @Column(nullable = false)
    private String cookingTime;

    @Column(nullable = false)
    private Difficulty difficulty;

    @Column(nullable = false)
    private LocalDate createTime;

    @Column(nullable = false)
    private Long writerId;

    @Builder
    public Food(String name, Integer serving, String cookingTime, Difficulty difficulty, Long writerId) {
        this.name = name;
        this.serving = serving;
        this.cookingTime = cookingTime;
        this.difficulty = difficulty;
        this.createTime = LocalDate.now();
        this.writerId = writerId;
    }
}
