package com.revature.save_the_date.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.save_the_date.models.Employee;
import com.revature.save_the_date.services.EmployeeService;

public class EmployeeServlet extends HttpServlet {

	private final EmployeeService employeeService;
	private final ObjectMapper mapper;

	public EmployeeServlet(EmployeeService employeeService, ObjectMapper mapper) {
		this.employeeService = employeeService;
		this.mapper = mapper;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String role = req.getParameter("role");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		
		String json = new JSONObject().put("fname"	, fname)
				.put("lname",lname)
				.put("role",role)				
				.put("email",email)
				.put("password",password).toString();
		
		try {
			Employee newEmployee = mapper.readValue(json, Employee.class);
			boolean wasRegistered = employeeService.addEmployee(newEmployee);
			if (wasRegistered) {
				resp.setStatus(200);
				resp.getWriter().write("data persisted succesfully");
				resp.sendRedirect("http://localhost:8080/saveTheDate/employee.html");

			} else {
				resp.setStatus(500);
			}
		} catch (StreamReadException | DatabindException e) { // TODO: handle exception
			resp.setStatus(400);
			e.printStackTrace();
		} catch (Exception e) {
			resp.setStatus(500);
			e.printStackTrace();
		}
	}

	

}
