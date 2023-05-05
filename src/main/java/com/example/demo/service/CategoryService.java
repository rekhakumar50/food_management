package com.example.demo.service;

import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Category;
import com.example.demo.dao.Food;
import com.example.demo.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryService {
	
	private CategoryRepository categoryRepository;
	
	
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	
	
	public void updateCategory(Category category) {
		categoryRepository.save(category);
	}
	
	
	public void deleteCategoryByName(String categoryName) {
		categoryRepository.deleteCategoryByCategoryName(categoryName);
	}
	
	
	public void getAllCategory() {
		categoryRepository.findAll();
	}
	
	
	public void getFoodByCategory(String categoryName) {
		categoryRepository.findFoodByCategory(categoryName);
	}
	
	
	public Category getCategoryByName(String categoryName) {
		Category category = null;
		Optional<Category> categoryOp = categoryRepository.findCategoryByCategoryName(categoryName);
		if(categoryOp.isPresent())
			category = categoryOp.get();
		return category;
	}
	

	public boolean existByCategoryName(String categoryName) {
		boolean isCategoryExist = false;
		if(StringUtils.isNotBlank(categoryName)) {
			isCategoryExist = categoryRepository.existsByCategoryName(categoryName);
		}
		return isCategoryExist;
	}
}
