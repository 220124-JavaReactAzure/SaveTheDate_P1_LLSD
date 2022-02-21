package com.revature.save_the_date.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.save_the_date.services.AttendeeService;


public class AttendeeServlet extends HttpServlet{

	public AttendeeServlet(AttendeeService attendeeService) {
		
		
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException, ServletException  {
		resp.getWriter().write("<head><title>Save The Date</title></head>");
		resp.getWriter().write("<h1>Welcome!</h1>");
		resp.getWriter().write("<select name='Food'> "
				+ "<option value ='Fish'>Fish</option>"
				+ "<option value = 'Meat'>Meat</option>"
				+ "<option value ='Vegetarian'>Vegetarian</option>"
				+"</select>");
	}
	
	

}
