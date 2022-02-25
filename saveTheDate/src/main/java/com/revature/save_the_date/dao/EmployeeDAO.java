package com.revature.save_the_date.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.save_the_date.hibernate.util.HibernateUtil;
import com.revature.save_the_date.models.Employee;

public class EmployeeDAO {
	
	public boolean addEmployee(Employee employee) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();

			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			HibernateUtil.closeSession();
			return false;
		}
	}
	
	public List<Employee> getAllEmployeess(){
		return null;
	}
	
	public Employee getEmployeesById(int id) {
		return null;
	}
	
	public void updateWeddingWithSessionMethod(Employee employee) {
		
	}


}
