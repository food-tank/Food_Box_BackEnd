package com.food.foodbox.domain.food.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false, length = 200)
    private String content;

    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    public Recipe(String title, String content, String imgUrl, Food food) {
        this.title = title;
        this.content = content;
        this.imgUrl = imgUrl;
        this.food = food;
    }
}
