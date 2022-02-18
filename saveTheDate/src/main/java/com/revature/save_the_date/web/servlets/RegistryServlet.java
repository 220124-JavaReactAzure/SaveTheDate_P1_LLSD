package com.revature.save_the_date.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.save_the_date.services.RegistryService;
import com.revature.save_the_date.services.WeddingService;

@WebServlet(value="/registry")
public class RegistryServlet extends HttpServlet{
	
	public RegistryServlet(RegistryService registryService) {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("helooooooooooooooooooooooooooo");
	}

}
