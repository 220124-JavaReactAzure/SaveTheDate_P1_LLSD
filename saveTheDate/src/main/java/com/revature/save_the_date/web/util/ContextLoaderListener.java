package com.revature.save_the_date.web.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.save_the_date.dao.GuestDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.save_the_date.dao.EmployeeDAO;
import com.revature.save_the_date.dao.RegistryDAO;
import com.revature.save_the_date.dao.WeddingDAO;
import com.revature.save_the_date.services.EmployeeService;
import com.revature.save_the_date.services.RegistryService;
import com.revature.save_the_date.services.WeddingService;
import com.revature.save_the_date.web.servlets.WeddingServlet;

public class ContextLoaderListener implements ServletContextListener {

	private final Logger logger = LogManager.getLogger();

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("Initializing Application.....");
		ObjectMapper mapper = new ObjectMapper();
		
		WeddingDAO weddingDAO = new WeddingDAO();
		WeddingService weddingService = new WeddingService(weddingDAO);
		WeddingServlet weddingServlet = new WeddingServlet(weddingService, mapper);
		
		ServletContext context = sce.getServletContext();
		context.addServlet("WeddingServlet",weddingServlet).addMapping("/wedding/*");

		GuestDAO attendeeDAO = new GuestDAO();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		RegistryDAO registryDAO = new RegistryDAO();

		//WeddingService weddingService = new WeddingService(weddingDAO);
		// EmployeeService employeeService = new EmployeeService(employeeDAO,
		// weddingService);
		RegistryService registryService = new RegistryService(registryDAO);

		logger.info("Application initialized@");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}

}
