package com.revature.save_the_date.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "employee")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "employee_id")
@JsonIgnoreProperties(value = "wedding", allowGetters = true)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int employee_id;

	@Column(name = "fname")
	private String fname;

	@Column(name = "lname")
	private String lname;

	@Column(name = "role")
	private String role;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "cost")
	private double cost;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_wed_id", referencedColumnName = "wedding_id", nullable = false)
	public Wedding emp_wed_id;

	public Employee(int employee_id, String fname, String lname, String role, String email, String password,
			double cost, Wedding emp_wed_id) {
		super();
		this.employee_id = employee_id;
		this.fname = fname;
		this.lname = lname;
		this.role = role;
		this.email = email;
		this.password = password;
		this.cost = cost;
		this.emp_wed_id = emp_wed_id;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	// getters and setters
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFname() {
		return fname;
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Wedding getWedding() {
		return emp_wed_id;
	}

	public void setWedding(Wedding wedding) {
		this.emp_wed_id = wedding;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", fname=" + fname + ", lname=" + lname + ", role=" + role
				+ ", email=" + email + ", password=" + password + ", cost=" + cost + ", emp_wed_id=" + emp_wed_id + "]";
	}


}
