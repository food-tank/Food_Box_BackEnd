package com.food.foodbox.domain.food.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private Long id;

    @Column(length = 50)
    private String name;

    private String purchaseLink;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    public Material(String name, String purchaseLink, Food food) {
        this.name = name;
        this.purchaseLink = purchaseLink;
        this.food = food;
    }
}
