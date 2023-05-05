package com.example.demo.mapper;

import java.util.Objects;

import com.example.demo.dao.Food;
import com.example.demo.dto.FoodDto;

public class FoodMapper {
		
	public static FoodDto convertToFoodDto(Food food) {
		FoodDto foodDto = null;
		
		if(Objects.nonNull(food)) {
			if(Objects.nonNull(food.getCategory())) {
				foodDto = new FoodDto(
							food.getId(), 
							food.getFoodName(), 
							food.getPrice(), 
							food.isAvailability(), 
							food.getCategory().getCategoryName());
			} else {
				foodDto = new FoodDto(
						food.getId(), 
						food.getFoodName(), 
						food.getPrice(), 
						food.isAvailability(),
						null);
			}
		}
				
		return foodDto;
	}
}
