package com.food.foodbox.infrastructure.persistence.Food;

import com.food.foodbox.domain.food.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface materialRepository extends JpaRepository<Material, Long> {
}
