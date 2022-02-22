package com.revature.save_the_date.web.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.save_the_date.dao.GuestDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.save_the_date.dao.EmployeeDAO;
import com.revature.save_the_date.dao.FoodDAO;
import com.revature.save_the_date.dao.RegistryDAO;
import com.revature.save_the_date.dao.VenueDAO;
import com.revature.save_the_date.dao.WeddingDAO;
import com.revature.save_the_date.services.EmployeeService;
import com.revature.save_the_date.services.FoodService;
import com.revature.save_the_date.services.GuestService;
import com.revature.save_the_date.services.RegistryService;
import com.revature.save_the_date.services.VenueService;
import com.revature.save_the_date.services.WeddingService;
import com.revature.save_the_date.web.servlets.EmployeeServlet;
import com.revature.save_the_date.web.servlets.FoodServlet;
import com.revature.save_the_date.web.servlets.GuestServlet;
import com.revature.save_the_date.web.servlets.RegistryServlet;
import com.revature.save_the_date.web.servlets.VenueServlet;
import com.revature.save_the_date.web.servlets.WeddingServlet;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

	private final Logger logger = LogManager.getLogger();

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("Initializing Application.....");

		ObjectMapper mapper = new ObjectMapper();

		
		  WeddingDAO weddingDAO = new WeddingDAO(); WeddingService weddingService = new
		  WeddingService(weddingDAO); WeddingServlet weddingServlet = new
		  WeddingServlet(weddingService, mapper);
		  
		  RegistryDAO registryDAO = new RegistryDAO(); RegistryService registryService
		  = new RegistryService(registryDAO); RegistryServlet registryServlet = new
		  RegistryServlet(registryService, mapper);
		 
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeService employeeService = new EmployeeService(employeeDAO);
		EmployeeServlet employeeServlet = new EmployeeServlet(employeeService, mapper);

		
		  GuestDAO guestDAO = new GuestDAO(); GuestService guestService = new
		  GuestService(guestDAO); GuestServlet guestServlet = new
		  GuestServlet(guestService, mapper);
		  
		  FoodDAO foodDAO = new FoodDAO(); FoodService foodService = new
		  FoodService(foodDAO); FoodServlet foodServlet = new FoodServlet(foodService,
		  mapper);
		 
		VenueDAO venueDAO = new VenueDAO();
		VenueService venueService = new VenueService(venueDAO);
		VenueServlet venueServlet = new VenueServlet(venueService, mapper);

		ServletContext context = sce.getServletContext();

		context.addServlet("WeddingServlet", weddingServlet).addMapping("/wedding/*");
		context.addServlet("RegistryServlet", registryServlet).addMapping("/registry/*");
		context.addServlet("FoodServlet", foodServlet).addMapping("/food/*");
		context.addServlet("GuestServlet", guestServlet).addMapping("/guest/*");
		context.addServlet("EmployeeServlet", employeeServlet).addMapping("/employee/*");
		context.addServlet("VenueServlet", venueServlet).addMapping("/venue/");

		logger.info("Application initialized@");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}

}
