package com.revature.save_the_date.services;

import java.util.List;

import com.revature.save_the_date.dao.VenueDAO;
import com.revature.save_the_date.models.Venue;

public class VenueService {
	private final VenueDAO venueDAO;

	public VenueService(VenueDAO venueDAO) {
		super();
		this.venueDAO = venueDAO;
	}
	
	public boolean addVenue(Venue venue) {
		return venueDAO.addVenue(venue);
	}
	
	public List<Venue> getAllVenues(){
		return venueDAO.getAllVenues();
	}
	
	public Venue getVenueById(int id) {
		return venueDAO.getVenueById(id);
	}
	
	public void updateVenueWithSessionMethod(Venue venue) {
		
	}
	
	public void updateVenueWithHQL(Venue venue) {
		
	}

}
