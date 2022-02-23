package com.revature.save_the_date.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guests")
public class Guest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "guest_id")
	private int guest_id;

	@Column(name = "fname")
	private String fname;

	@Column(name = "lname")
	private String lname;
	
	@Column(name = "plus_one")
	private int plus_one;
	
	@Column(name = "food")
	private String food;
	
	@Column(name = "plus_one_food")
	private String plus_one_food;
	
	@Column(name = "guest_type")
	private String guest_type;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;

	
	
	public Guest(int guest_id, String fname, String lname, int plus_one, String food, String plus_one_food,
			String guest_type, String email, String password) {
		super();
		this.guest_id = guest_id;
		this.fname = fname;
		this.lname = lname;
		this.plus_one = plus_one;
		this.food = food;
		this.plus_one_food = plus_one_food;
		this.guest_type = guest_type;
		this.email = email;
		this.password = password;
	}
	

	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}


	// getters and setters
	public int getGuest_id() {
		return guest_id;
	}

	public int getPlus_one() {
		return plus_one;
	}

	public void setPlus_one(int plus_one) {
		this.plus_one = plus_one;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getPlus_one_food() {
		return plus_one_food;
	}

	public void setPlus_one_food(String plus_one_food) {
		this.plus_one_food = plus_one_food;
	}

	public void setGuest_id(int guest_id) {
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
	
	public String getGuest_type() {
		return guest_type;
	}

	public void setGuest_type(String guest_type) {
		this.guest_type = guest_type;
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
		return "Guest [guest_id=" + guest_id + ", fname=" + fname + ", lname=" + lname + ", plus_one=" + plus_one
				+ ", food=" + food + ", plus_one_food=" + plus_one_food + ", guest_type=" + guest_type + ", email="
				+ email + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, fname, food, guest_id, guest_type, lname, password, plus_one, plus_one_food);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guest other = (Guest) obj;
		return Objects.equals(email, other.email) && Objects.equals(fname, other.fname)
				&& Objects.equals(food, other.food) && Objects.equals(guest_id, other.guest_id)
				&& Objects.equals(guest_type, other.guest_type) && Objects.equals(lname, other.lname)
				&& Objects.equals(password, other.password) && plus_one == other.plus_one
				&& Objects.equals(plus_one_food, other.plus_one_food);
	}



	
	

}
