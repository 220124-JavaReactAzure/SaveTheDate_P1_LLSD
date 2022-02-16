package com.revature.save_the_date;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/register")
public class RegisterServlet extends HttpServlet{

	
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException, ServletException  {
		resp.getWriter().write("<head><title>Save The Date</title></head>");
		resp.getWriter().write("<h1>Please choose your preferred type of food</h1>");
		resp.getWriter().write("<select name='Food'> "
				+ "<option value ='Fish'>Fish</option>"
				+ "<option value = 'Meat'>Meat</option>"
				+ "<option value ='Vegetarian'>Vegetarian</option>"
				+"</select>");
	}

}
