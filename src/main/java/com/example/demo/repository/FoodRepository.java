package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dao.Category;
import com.example.demo.dao.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
	
	List<Food> findByFoodNameLike(String foodName);
	
	Optional<Food> findByFoodName(String foodName);
		
	@Modifying
	@Query("Delete from Food f where f.foodName=:foodName")
	void deleteFoodByFoodName(String foodName);

	void deleteFoodByCategory(Category category);

}
