package com.food.foodbox.infrastructure.persistence.food;

import com.food.foodbox.domain.food.domain.Food;
import com.food.foodbox.domain.food.domain.type.Type;
import com.food.foodbox.domain.user.domain.User;
import com.food.foodbox.shared.error.exception.ErrorCode;
import com.food.foodbox.shared.error.exception.FoodBoxException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findByWriterId(Long writerId);
    Page<Food> findByTypeOrderByIdDesc(Type type, Pageable pageable);
    Page<Food> findByTypeOrderByLikeCountDescIdDesc(Type type, Pageable pageable);
    List<Food> findByNameContainsOrContentContains(String name, String content);

    @Query("select f " +
            "from User u join Like l on u.id = l.userId " +
            "join Food f on l.foodId = f.id " +
            "where u = :user")
    List<Food> findLikeProject(User user);

    default Food getById(Long id) {
        return findById(id)
                .orElseThrow(() -> new FoodBoxException(ErrorCode.FOOD_NOT_FOUND));
    }
}
