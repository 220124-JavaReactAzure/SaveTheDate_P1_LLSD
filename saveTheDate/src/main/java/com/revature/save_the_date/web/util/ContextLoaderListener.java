package com.revature.save_the_date.web.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.save_the_date.dao.AttendeeDAO;
import com.revature.save_the_date.dao.EmployeeDAO;
import com.revature.save_the_date.dao.EspousedDAO;
import com.revature.save_the_date.dao.RegistryDAO;
import com.revature.save_the_date.dao.WeddingDAO;
import com.revature.save_the_date.services.AttendeeService;
import com.revature.save_the_date.services.EmployeeService;
import com.revature.save_the_date.services.EspousedService;
import com.revature.save_the_date.services.RegistryService;
import com.revature.save_the_date.services.WeddingService;


public class ContextLoaderListener implements ServletContextListener{

	private final Logger logger = LogManager.getLogger();
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("Initializing Application.....");
		
		AttendeeDAO attendeeDAO = new AttendeeDAO();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EspousedDAO espousedDAO = new EspousedDAO();
		RegistryDAO registryDAO = new RegistryDAO();
		WeddingDAO weddingDAO = new WeddingDAO();
		
		WeddingService weddingService = new WeddingService(weddingDAO);
		AttendeeService attendeeService = new AttendeeService(attendeeDAO, weddingService);
		EmployeeService employeeService = new EmployeeService(employeeDAO, weddingService);
		EspousedService espousedService = new EspousedService(espousedDAO, weddingService);
		RegistryService registryService = new RegistryService(registryDAO, weddingService);
	
		logger.info("Application initialized@");
	}
	
		@Override
		public void contextDestroyed(ServletContextEvent sce) {
			// TODO Auto-generated method stub
			ServletContextListener.super.contextDestroyed(sce);
		}
			

}
