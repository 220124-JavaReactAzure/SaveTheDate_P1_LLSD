package com.revature.save_the_date.web.util;

import java.io.BufferedReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.revature.save_the_date.dao.AttendeeDAO;
import com.revature.save_the_date.dao.EmployeeDAO;
import com.revature.save_the_date.dao.EspousedDAO;
import com.revature.save_the_date.dao.RegisterDAO;
import com.revature.save_the_date.dao.RegistryDAO;
import com.revature.save_the_date.dao.WeddingDAO;
import com.revature.save_the_date.services.AttendeeService;
import com.revature.save_the_date.services.EmployeeService;
import com.revature.save_the_date.services.EspousedService;
import com.revature.save_the_date.services.RegisterService;
import com.revature.save_the_date.services.RegistryService;
import com.revature.save_the_date.services.WeddingService;
import com.revature.save_the_date.web.servlets.AttendeeServlet;
import com.revature.save_the_date.web.servlets.EmployeeServlet;
import com.revature.save_the_date.web.servlets.EspousedServlet;
import com.revature.save_the_date.web.servlets.RegisterServlet;
import com.revature.save_the_date.web.servlets.RegistryServlet;
import com.revature.save_the_date.web.servlets.WeddingServlet;

@WebListener
public class ContextLoaderListener implements ServletContextListener{

	private final Logger logger = LogManager.getLogger();
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		logger.info("Initializing Application.....");
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate5Module());
		
		
		AttendeeDAO attendeeDAO = new AttendeeDAO();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EspousedDAO espousedDAO = new EspousedDAO();
		RegistryDAO registryDAO = new RegistryDAO();
		WeddingDAO weddingDAO = new WeddingDAO();
		RegisterDAO registerDAO = new RegisterDAO();
		
		WeddingService weddingService = new WeddingService(weddingDAO);
		AttendeeService attendeeService = new AttendeeService(attendeeDAO, weddingService);
		EmployeeService employeeService = new EmployeeService(employeeDAO, weddingService);
		EspousedService espousedService = new EspousedService(espousedDAO, weddingService);
		RegistryService registryService = new RegistryService(registryDAO, weddingService);
		RegisterService registerService = new RegisterService(registerDAO, attendeeService, employeeService, espousedService, weddingService);
		
		WeddingServlet weddingServlet = new WeddingServlet(weddingService, espousedService, employeeService, attendeeService, mapper);
		AttendeeServlet attendeeServlet = new AttendeeServlet(attendeeService);
		EmployeeServlet employeeServlet = new EmployeeServlet(employeeService);
		EspousedServlet espousedServlet  = new EspousedServlet(weddingService, espousedService, registryService);
		RegistryServlet registryServlet = new RegistryServlet(registryService);
		RegisterServlet registerServlet = new RegisterServlet(registerService);
		
		
		
		
		ServletContext context = sce.getServletContext();
		context.addServlet("WeddingServlet", weddingServlet).addMapping("/weddings/*");
		context.addServlet("AttendeeServlet", attendeeServlet).addMapping("/attendee/*");
		context.addServlet("EmployeeServlet", employeeServlet).addMapping("/employee/*");
		context.addServlet("EspousedServlet", espousedServlet).addMapping("/espoused/*");
		context.addServlet("RegistryServlet", registryServlet).addMapping("/registry/*");
		context.addServlet("RegisterServlet", registerServlet).addMapping("/register/*");
		logger.info("Application initialized");
	}
	
		@Override
		public void contextDestroyed(ServletContextEvent sce) {
			// TODO Auto-generated method stub
			ServletContextListener.super.contextDestroyed(sce);
		}
			

}
