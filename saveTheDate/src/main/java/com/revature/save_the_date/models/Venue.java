package com.revature.save_the_date.models;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="venue")
public class Venue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="venue_id")
	private String venue_id;
	@Column(name="venue_name")
	private String venue_name;
	@Column(name="phone_no")
	private int phone_no;
	@Column(name="capacity")
	private int capacity;	
	@Column(name="address")
	
	
	private String address;
	public String getVenue_id() {
		return venue_id;
	}
	public void setVenue_id(String venue_id) {
		this.venue_id = venue_id;
	}
	public String getVenue_name() {
		return venue_name;
	}
	public void setVenue_name(String venue_name) {
		this.venue_name = venue_name;
	}
	public int getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(int phone_no) {
		this.phone_no = phone_no;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Venue(String venue_id, String venue_name, int phone_no, int capacity, String address) {
		super();
		this.venue_id = venue_id;
		this.venue_name = venue_name;
		this.phone_no = phone_no;
		this.capacity = capacity;
		this.address = address;
	}
	public Venue() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	///getters and setters
	
	
	
	

}


