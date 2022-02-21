package com.revature.save_the_date.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.save_the_date.hibernate.util.HibernateUtil;
import com.revature.save_the_date.models.Venue;
import com.revature.save_the_date.models.Wedding;

public class VenueDAO {
	
	public boolean addVenue(Venue venue) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(venue);
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Venue> getAllVenues(){
		return null;
	}
	
	public Venue getVenueById(int id) {
		return null;
	}
	
	public void updateVenueWithSessionMethod(Venue venue) {
		
	}


}
