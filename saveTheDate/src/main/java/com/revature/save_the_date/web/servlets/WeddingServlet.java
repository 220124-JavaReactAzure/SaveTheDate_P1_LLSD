package com.revature.save_the_date.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.save_the_date.services.AttendeeService;
import com.revature.save_the_date.services.EmployeeService;
import com.revature.save_the_date.services.EspousedService;
import com.revature.save_the_date.services.WeddingService;

//@WebServlet("/home")
public class WeddingServlet extends HttpServlet{
	public WeddingServlet(WeddingService weddingService, EspousedService espousedService,
			EmployeeService employeeService, AttendeeService attendeeService, ObjectMapper mapper) {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.getWriter().write("<head><title>Save The Date !</title></head>"
				+ "<img src='./images/savethedate.png' alt='logos'/>"
				+ "<body>"
				+ "<h1> Home </h1>"
				+ "<div id='intro'> "
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				
				// CSS
				
				+ "<style type=text/css>"
				+ "body {background-color: #79525C;}"
				+ ""
				+ "</body>"
				+ "</style>");
	}

}
