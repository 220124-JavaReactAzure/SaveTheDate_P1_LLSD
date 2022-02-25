package com.revature.save_the_date.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wedding")
public class Wedding {
	
	
	@Column(name="wedding_date")
	private String wedding_date;
	
	@Column(name="wedding_venue")
	private String wedding_venue;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="wedding_id")
	private int wedding_id;
	
	
	
	
	

	public Wedding() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wedding( int wedding_id, String wedding_venue, String wedding_date) {
		super();
		this.wedding_id = wedding_id;
		this.wedding_venue = wedding_venue;
		this.wedding_date = wedding_date;
		// TODO Auto-generated constructor stub
	}
	
	//getters and setters

	public String getWedding_date() {
		return wedding_date;
	}

	public void setWedding_date(String wedding_date) {
		this.wedding_date = wedding_date;
	}

	public String getWedding_venue() {
		return wedding_venue;
	}

	public void setWedding_venue(String wedding_venue) {
		this.wedding_venue = wedding_venue;
	}

	public int getWedding_id() {
		return wedding_id;
	}

	public void setWedding_id(int wedding_id) {
		this.wedding_id = wedding_id;
	}
	
	

}


