package com.revature.save_the_date.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Guest {

	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "guest_id")
	private String guest_id;

	@Column(name = "fname")
	private String fname;

	@Column(name = "lname")
	private String lname;
	
	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	

	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Guest(String guest_id, String fname, String lname, String email, String password) {
		super();
		this.guest_id = guest_id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
	}

	public String getGuest_id() {
		return guest_id;
	}

	public void setGuest_id(String guest_id) {
		this.guest_id = guest_id;
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
		return "Guest [guest_id=" + guest_id + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", password=" + password + "]";
	}

	
	
	
	

}
