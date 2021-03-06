package com.revature.save_the_date.services;

import java.util.List;

import com.revature.save_the_date.dao.EmployeeDAO;
import com.revature.save_the_date.models.Employee;

public class EmployeeService {
	
	private final EmployeeDAO employeeDAO;

	public EmployeeService(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
		// TODO Auto-generated constructor stub
	}
	
	public boolean addEmployee(Employee employee) {
		return employeeDAO.addEmployee(employee);
	}
	
	public List<Employee> getAllEmployees(){
		return employeeDAO.getAllEmployees();
	}
	
	public Employee getEmployeeById(int id) {
		return employeeDAO.getEmployeesById(id);
	}
	
	public void updateEmployeeWithSessionMethod(Employee employee) {
		
	}
	
	public void updateEmployeeWithHQL(Employee employee) {
		
	}


}
