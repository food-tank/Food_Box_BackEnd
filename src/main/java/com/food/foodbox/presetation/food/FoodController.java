package com.food.foodbox.presetation.food;

import com.food.foodbox.application.food.command.CreateFoodService;
import com.food.foodbox.application.food.command.DeleteFoodService;
import com.food.foodbox.application.food.command.UpdateFoodService;
import com.food.foodbox.application.food.command.UploadImageService;
import com.food.foodbox.application.food.query.*;
import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.infrastructure.s3.dto.response.ImageResponse;
import com.food.foodbox.infrastructure.security.util.SecurityUtil;
import com.food.foodbox.presetation.food.dto.request.CreateFoodRequest;
import com.food.foodbox.presetation.food.dto.response.FoodInfoResponse;
import com.food.foodbox.presetation.food.dto.response.FoodResponse;
import com.food.foodbox.presetation.food.dto.response.FoodsResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodController {

    private final CreateFoodService createFoodService;
    private final UploadImageService uploadImageService;
    private final DeleteFoodService deleteFoodService;
    private final UpdateFoodService updateFoodService;
    private final QueryRecentFoodListService queryRecentFoodListService;
    private final QueryFoodService queryFoodService;
    private final QuerySearchFoodService querySearchFoodService;
    private final QueryLikeFoodService queryLikeFoodService;
    private final QueryLikeCountFoodListService queryLikeCountFoodListService;
    private final QueryMyFoodListService queryMyFoodListService;

    @GetMapping()
    public ResponseEntity<FoodsResponse> getAll(
            @RequestParam(name = "criteria", required = false, defaultValue = "recent") String criteria,
            @RequestParam(name = "type", required = false, defaultValue = "DIET") String type,
            @RequestParam int size,
            @RequestParam int page
    ) {
        User user = SecurityUtil.getCurrentUserOrNotLogin();
        Pageable pageable = PageRequest.of(page, size);
        if (criteria.equals("like")) {
            return ResponseEntity.ok(queryLikeCountFoodListService.execute(user, type, pageable));
        }

        return ResponseEntity.ok(queryRecentFoodListService.execute(user, type, pageable));
    }

    @GetMapping("/{food-id}")
    public ResponseEntity<FoodInfoResponse> getOne(@PathVariable(name = "food-id") Long foodId) {
        return ResponseEntity.ok(queryFoodService.execute(foodId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<FoodResponse>> search(@RequestParam(name = "q") String q) {
        User user = SecurityUtil.getCurrentUserOrNotLogin();
        return ResponseEntity.ok(querySearchFoodService.execute(user, q));
    }

    @GetMapping("/liked")
    public ResponseEntity<List<FoodResponse>> getLiked() {
        User user = SecurityUtil.getCurrentUserWithLogin();
        return ResponseEntity.ok(queryLikeFoodService.execute(user));
    }

    @GetMapping("/my")
    public ResponseEntity<List<FoodResponse>> getMy() {
        User user = SecurityUtil.getCurrentUserWithLogin();
        return ResponseEntity.ok(queryMyFoodListService.execute(user));
    }

    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody CreateFoodRequest request) {
        User user = SecurityUtil.getCurrentUserWithLogin();
        createFoodService.execute(user, request);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/image")
    public ImageResponse uploadImage(@RequestPart("image") MultipartFile image) {
        return uploadImageService.execute(image);
    }

    @DeleteMapping("/{food-id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "food-id") Long foodId) {
        User user = SecurityUtil.getCurrentUserWithLogin();
        deleteFoodService.execute(user, foodId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{food-id}")
    public ResponseEntity<Void> update(@PathVariable(name = "food-id") Long foodId, @RequestBody CreateFoodRequest request) {
        User user = SecurityUtil.getCurrentUserWithLogin();
        updateFoodService.execute(user, foodId, request);
        return ResponseEntity.noContent().build();
    }
}
