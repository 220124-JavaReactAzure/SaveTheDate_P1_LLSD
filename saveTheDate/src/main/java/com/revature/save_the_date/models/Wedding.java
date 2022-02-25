package com.revature.save_the_date.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Wedding")
public class Wedding {
	
	
	@Column(name="wedding_date")
	private String wedding_date;
	
	@Column(name="wedding_venue")
	private String wedding_venue;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="wedding_id")
	private String wedding_id;
	
	@Column(name="bride")
	private String bride;
	
	@Column(name="groom")
	private String groom;
	
	@Column(name="party_size")
	private int party_size;
	
	@Column(name="budget")
	private int budget;
	
	@Column(name="caterer")
	private String caterer;
	
	@Column(name="florist")
	private String florist;
	
	@Column(name="photographer")
	private String photographer;
	
	@Column(name="musician")
	private String musician;
	
	
	
	
	
	
	
	
	

	public String getBride() {
		return bride;
	}

	public void setBride(String bride) {
		this.bride = bride;
	}

	public String getGroom() {
		return groom;
	}

	public void setGroom(String groom) {
		this.groom = groom;
	}

	public int getParty_size() {
		return party_size;
	}

	public void setParty_size(int party_size) {
		this.party_size = party_size;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	

	

	public String getCaterer() {
		return caterer;
	}

	public void setCaterer(String caterer) {
		this.caterer = caterer;
	}

	public String getFlorist() {
		return florist;
	}

	public void setFlorist(String florist) {
		this.florist = florist;
	}

	public String getPhotographer() {
		return photographer;
	}

	public void setPhotographer(String photographer) {
		this.photographer = photographer;
	}

	public String getMusician() {
		return musician;
	}

	public void setMusician(String musician) {
		this.musician = musician;
	}

	public Wedding() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	//getters and setters

	public Wedding(String wedding_date, String wedding_venue, String wedding_id, String bride, String groom,
			int party_size, int budget, String caterer, String florist, String photographer, String musician) {
		super();
		this.wedding_date = wedding_date;
		this.wedding_venue = wedding_venue;
		this.wedding_id = wedding_id;
		this.bride = bride;
		this.groom = groom;
		this.party_size = party_size;
		this.budget = budget;
		this.caterer = caterer;
		this.florist = florist;
		this.photographer = photographer;
		this.musician = musician;
	}

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

	public String getWedding_id() {
		return wedding_id;
	}

	public void setWedding_id(String wedding_id) {
		this.wedding_id = wedding_id;
	}
	
	

}


