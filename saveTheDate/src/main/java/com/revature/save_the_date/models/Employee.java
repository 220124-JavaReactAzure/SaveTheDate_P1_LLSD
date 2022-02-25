package com.revature.save_the_date.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	
	@Column(name = "fname")
	private String fname;
	@Column(name = "lname")
	private String lname;
	@Column(name = "role")
	private String role;
	@Id
	@Column(name = "email")	
	private String email;
	@Column(name = "password")
	private String password;

	// getters and setters
	
	
	

	public String getFname() {
		return fname;
	}

	public Employee( String fname, String lname, String role, String email, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.role = role;
		this.email = email;
		this.password = password;
	}
	
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [fname=" + fname + ", lname=" + lname + ", role=" + role + ", email=" + email + ", password="
				+ password + "]";
	}

	
	
	
	

}
