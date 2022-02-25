package com.revature.save_the_date.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.save_the_date.models.Food;
import com.revature.save_the_date.services.FoodService;

public class FoodServlet extends HttpServlet {

	private final FoodService foodService;
	private final ObjectMapper mapper;

	public FoodServlet(FoodService foodService, ObjectMapper mapper) {
		this.foodService = foodService;
		this.mapper = mapper;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/json");
		try {
			Food newFood = mapper.readValue(req.getInputStream(), Food.class);
			boolean wasRegistered = foodService.addFood(newFood);
			if (wasRegistered) {
				resp.setStatus(200);
			} else {
				resp.setStatus(500);
			}
		} catch (StreamReadException | DatabindException e) { // TODO: handle exception resp.setStatus(400);
			e.printStackTrace();
		} catch (Exception e) {
			resp.setStatus(500);
			e.printStackTrace();
		}

	}

}
