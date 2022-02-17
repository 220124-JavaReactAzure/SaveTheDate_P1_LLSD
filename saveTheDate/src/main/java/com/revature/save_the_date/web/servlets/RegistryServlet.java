package com.revature.save_the_date.web.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.revature.save_the_date.services.RegistryService;
import com.revature.save_the_date.services.WeddingService;

@WebServlet(value="/registry")
public class RegistryServlet extends HttpServlet{

	public RegistryServlet(RegistryService registryService) {
		// TODO Auto-generated constructor stub
	}

}
