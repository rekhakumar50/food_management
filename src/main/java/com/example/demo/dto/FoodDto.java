package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDto {
	
	private long id;
	
	private String foodName;
	
	private double price;
	
	private boolean availability;
	
    private String category;

}
