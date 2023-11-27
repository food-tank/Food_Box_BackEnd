package com.food.foodbox.domain.food.domain;

import com.food.foodbox.domain.food.domain.type.Difficulty;
import com.food.foodbox.domain.food.domain.type.Type;
import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.presetation.food.dto.request.CreateFoodRequest;
import com.food.foodbox.shared.error.exception.ErrorCode;
import com.food.foodbox.shared.error.exception.FoodBoxException;
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

    @Column(length = 300)
    private String content;

    @Column(nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private Integer likeCount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(nullable = false)
    private LocalDate createTime;

    @Column(nullable = false)
    private Long writerId;

    @Builder
    public Food(String name, Integer serving, String cookingTime, String content, String imgUrl, Difficulty difficulty, Type type, Long writerId) {
        this.name = name;
        this.serving = serving;
        this.cookingTime = cookingTime;
        this.content = content;
        this.imgUrl = imgUrl;
        this.likeCount = 0;
        this.difficulty = difficulty;
        this.type = type;
        this.createTime = LocalDate.now();
        this.writerId = writerId;
    }

    public void validateWriter(User user) {
        if (!this.writerId.equals(user.getId())) {
            throw new FoodBoxException(ErrorCode.IS_NOT_WRITER);
        }
    }

    public void update(CreateFoodRequest request) {
        this.name = request.name();
        this.serving = request.serving();
        this.cookingTime = request.cookingTime();
        this.content = request.content();
        this.imgUrl = request.imgUrl();
        this.difficulty = request.difficulty();
        this.type = request.type();
    }

    public void increaseLikeCount() {
        this.likeCount++;
    }

    public void decreaseLikeCount() {
        this.likeCount--;
    }
}
