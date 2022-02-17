package com.revature.save_the_date.web.servlets;

<<<<<<< HEAD
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.revature.save_the_date.services.RegistryService;
import com.revature.save_the_date.services.WeddingService;

@WebServlet(value="/registry")
public class RegistryServlet extends HttpServlet{

	public RegistryServlet(RegistryService registryService) {
		// TODO Auto-generated constructor stub
=======
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/registry")
public class RegistryServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("helooooooooooooooooooooooooooo");
>>>>>>> fa9125de520be592552159cca7d4ca0910b3dee8
	}

}
