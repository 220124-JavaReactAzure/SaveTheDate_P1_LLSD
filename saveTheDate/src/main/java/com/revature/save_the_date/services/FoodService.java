package com.revature.save_the_date.services;

import java.util.List;

import com.revature.save_the_date.dao.FoodDAO;
import com.revature.save_the_date.models.Food;

public class FoodService {
	private final FoodDAO foodDAO;
	
	
	
	public FoodService(FoodDAO foodDAO) {
		super();
		this.foodDAO = foodDAO;
		// TODO Auto-generated constructor stub
	}
	
	public boolean addFood(Food food) {
		return foodDAO.addFood(food);
	}

	public List<Food> getAllFood() {
		return null;
	}

	public Food getFoodById(int id) {
		return null;
	}

	public void updateFoodWithSessionMethod(Food food) {

	}

	public void updateFoodWithHQL(Food food) {

	}

}
