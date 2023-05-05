package com.example.demo.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dao.Category;
import com.example.demo.dao.Food;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	Optional<Category> findCategoryByCategoryName(String categoryName);

	boolean existsByCategoryName(String categoryName);
	
	void deleteCategoryByCategoryName(String categoryName);
	
	@Query("select c.foods from Category c where c.categoryName = :categoryName") 
	Set<Food> findFoodByCategory(String categoryName);

}
