package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.Category;
import com.example.demo.dao.Food;
import com.example.demo.dto.FoodDto;
import com.example.demo.mapper.FoodMapper;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.FoodRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FoodService {
	
	private FoodRepository foodRepository;
	
	private CategoryService categoryService;
	
	private CategoryRepository categoryRepository;
	
	
	public void addFood(Food food) {
		String categoryName = (Objects.nonNull(food) && Objects.nonNull(food.getCategory()))? food.getCategory().getCategoryName(): null;
		if(categoryService.existByCategoryName(categoryName)) {
			Category category = categoryService.getCategoryByName(categoryName);
			food.setCategory(category);
		} else {
			categoryRepository.save(food.getCategory());
		}
		foodRepository.save(food);
	}
	
	
	public void updateFood(Food food) {
		Optional<Food> foodOptional = foodRepository.findByFoodName(food.getFoodName());
		if(foodOptional.isPresent()) {
			Food saveFood = foodOptional.get();
			saveFood.setAvailability(food.isAvailability());
			saveFood.setPrice(food.getPrice());
			foodRepository.save(saveFood);
		}
	}
	
	
	@Transactional
	public void deleteFoodByName(String foodName) {
		foodRepository.deleteFoodByFoodName(foodName);
	}
	
	
	public List<FoodDto> getAllFood() {
		List<FoodDto> foodDtos = new ArrayList<>();
		
		List<Food> foods = foodRepository.findAll();
		if(CollectionUtils.isNotEmpty(foods)) {
			foodDtos = foods.stream()
							.map(f -> FoodMapper.convertToFoodDto(f))
							.collect(Collectors.toList());
		}
		return foodDtos;
	}
	
	
	public List<FoodDto> getFoodByName(String foodName) {
		List<FoodDto> foodDtos = new ArrayList<>();
		
		List<Food> foods = foodRepository.findByFoodNameLike(foodName);
		if(CollectionUtils.isNotEmpty(foods)) {
			foodDtos = foods.stream()
							.map(f -> FoodMapper.convertToFoodDto(f))
							.collect(Collectors.toList());
		}
		return foodDtos;
	}

}
