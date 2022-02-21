package com.revature.save_the_date.hibernate.util;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.revature.save_the_date.models.Employee;
import com.revature.save_the_date.models.Food;
import com.revature.save_the_date.models.Guest;
import com.revature.save_the_date.models.Registry;
import com.revature.save_the_date.models.Venue;
import com.revature.save_the_date.models.Wedding;

public class HibernateUtil {
	
	//hibernate replaces connection factory
	
	private static SessionFactory sessionFactory;
	private static Session session;
	
	public static Session getSession() throws IOException{
		
		if(sessionFactory==null) {
			Configuration configuration = new Configuration();
			Properties props = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			props.load(loader.getResourceAsStream("hibernate.properties"));
			
			configuration.setProperties(props);
			
			configuration.addAnnotatedClass(Wedding.class);
			//service registry
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			// ?????
			configuration.addAnnotatedClass(Employee.class);
			configuration.addAnnotatedClass(Venue.class);
			configuration.addAnnotatedClass(Guest.class);
			configuration.addAnnotatedClass(Food.class);
			configuration.addAnnotatedClass(Registry.class);


			
		} if(session == null) {
			//singleton implementation lazily constructed
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	public static void closeSession() {
		session.close();
		session = null;
	}

}
