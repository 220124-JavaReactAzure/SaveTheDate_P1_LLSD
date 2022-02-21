package com.revature.save_the_date.services;

import java.util.List;

import com.revature.save_the_date.dao.EmployeeDAO;
import com.revature.save_the_date.models.Employee;

public class EmployeeService {

	public EmployeeService(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
		// TODO Auto-generated constructor stub
	}
	
	public boolean addEmployee(Employee employee) {
		return employeeDAO.addEmployee(employee);
	}
	
	public List<Employee> getAllEmployees(){
		return null;
	}
	
	public Employee getEmployeeById(int id) {
		return null;
	}
	
	public void updateEmployeeWithSessionMethod(Employee employee) {
		
	}
	
	public void updateEmployeeWithHQL(Employee employee) {
		
	}


}
