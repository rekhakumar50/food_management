package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Food;
import com.example.demo.dto.FoodDto;
import com.example.demo.service.FoodService;

@RestController
@RequestMapping("/api")
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@PostMapping("food")
	public ResponseEntity<String> saveFood(@RequestBody Food food) {
		try {
			foodService.addFood(food);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>("Data Saved", HttpStatus.CREATED);
	}
	
	
	@GetMapping("food/{foodName}")
	public ResponseEntity<List<FoodDto>> getFood(@PathVariable String foodName) {
		List<FoodDto> foods = null;
		try {
			foods = foodService.getFoodByName(foodName);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(foods, HttpStatus.OK);
	}
	
	
	@GetMapping("foods")
	public ResponseEntity<List<FoodDto>> getAll() {
		List<FoodDto> foods = null;
		try {
			foods = foodService.getAllFood();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(foods, HttpStatus.OK);
	}
	
	
	@PutMapping("food")
	public ResponseEntity<String> updateFood(@RequestBody Food food) {
		try {
			foodService.updateFood(food);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>("Data Updated", HttpStatus.OK);
	}
	
	
	@DeleteMapping("food/{foodName}")
	public ResponseEntity<String> deleteFood(@PathVariable String foodName) {
		try {
			foodService.deleteFoodByName(foodName);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>("Data Deleted", HttpStatus.OK);
	}
	
}
