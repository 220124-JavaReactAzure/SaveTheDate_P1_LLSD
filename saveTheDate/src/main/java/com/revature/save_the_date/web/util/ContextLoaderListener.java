package com.revature.save_the_date.web.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.save_the_date.dao.GuestDAO;
import com.revature.save_the_date.dao.EmployeeDAO;
import com.revature.save_the_date.dao.RegistryDAO;
import com.revature.save_the_date.dao.WeddingDAO;
import com.revature.save_the_date.services.EmployeeService;
import com.revature.save_the_date.services.RegistryService;
import com.revature.save_the_date.services.WeddingService;


public class ContextLoaderListener implements ServletContextListener{

	private final Logger logger = LogManager.getLogger();
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("Initializing Application.....");
		
		GuestDAO attendeeDAO = new GuestDAO();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		RegistryDAO registryDAO = new RegistryDAO();
		WeddingDAO weddingDAO = new WeddingDAO();
		
		WeddingService weddingService = new WeddingService(weddingDAO);
		//EmployeeService employeeService = new EmployeeService(employeeDAO, weddingService);
		RegistryService registryService = new RegistryService(registryDAO, weddingService);
	
		logger.info("Application initialized@");
	}
	
		@Override
		public void contextDestroyed(ServletContextEvent sce) {
			// TODO Auto-generated method stub
			ServletContextListener.super.contextDestroyed(sce);
		}
			

}
