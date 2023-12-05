package com.food.foodbox.presetation.food;

import com.food.foodbox.application.food.query.QueryMaterialListService;
import com.food.foodbox.presetation.food.dto.response.MaterialResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/material")
public class MaterialController {

    private final QueryMaterialListService queryMaterialListService;

    @GetMapping("/{food-id}")
    @Operation(summary = "재료 조회")
    public ResponseEntity<List<MaterialResponse>> getByFood(@PathVariable(name = "food-id") Long fooId) {
        return ResponseEntity.ok(queryMaterialListService.execute(fooId));
    }
}
