package com.revature.save_the_date.web.servlets;

import javax.servlet.http.HttpServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.save_the_date.services.AttendeeService;
import com.revature.save_the_date.services.EmployeeService;
import com.revature.save_the_date.services.EspousedService;
import com.revature.save_the_date.services.WeddingService;

public class WeddingServlet extends HttpServlet {

	public WeddingServlet(WeddingService weddingService, EspousedService espousedService,
			EmployeeService employeeService, AttendeeService attendeeService, ObjectMapper mapper) {
		// TODO Auto-generated constructor stub
	}

}
