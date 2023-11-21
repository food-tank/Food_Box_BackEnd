package com.food.foodbox.application.food.query;

import com.food.foodbox.domain.food.domain.Material;
import com.food.foodbox.infrastructure.persistence.food.MaterialRepository;
import com.food.foodbox.presetation.food.dto.response.MaterialResponse;
import com.food.foodbox.shared.aunnotation.QueryService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@QueryService
@RequiredArgsConstructor
public class QueryMaterialListService {

    private final MaterialRepository materialRepository;

    public List<MaterialResponse> execute(Long foodId) {
        List<Material> materials = materialRepository.findByFoodId(foodId);
        return materials.stream()
                .map(MaterialResponse::from)
                .toList();
    }
}
