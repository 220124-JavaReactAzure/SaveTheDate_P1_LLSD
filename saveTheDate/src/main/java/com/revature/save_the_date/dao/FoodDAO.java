package com.revature.save_the_date.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.save_the_date.hibernate.util.HibernateUtil;
import com.revature.save_the_date.models.Food;

public class FoodDAO {

	public boolean addFood(Food food) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(food);
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			HibernateUtil.closeSession();

			return false;
		}
	}

	public List<Food> getAllFoods() {
		try {
			Session session = HibernateUtil.getSession();
			HibernateUtil.closeSession();
			
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			HibernateUtil.closeSession();
			return null;

			
		}
		return null;
	}

	public Food getFoodById(int id) {
		return null;
	}

	public void updateFoodWithSessionMethod(Food food) {

	}

}
