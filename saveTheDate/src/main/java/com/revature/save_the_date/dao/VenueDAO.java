package com.revature.save_the_date.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.save_the_date.hibernate.util.HibernateUtil;
import com.revature.save_the_date.models.Venue;
import com.revature.save_the_date.models.Wedding;

public class VenueDAO {
	
	public boolean addVenue(Venue venue) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(venue);
			transaction.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			HibernateUtil.closeSession();

			return false;
		}
	}
	
	public List<Venue> getAllVenues(){
		try {
			Session session = HibernateUtil.getSession();
			List<Venue> venues = session.createQuery("from Venue").list();
			return venues;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public Venue getVenueById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Venue venue = session.get(Venue.class, id);
			return venue;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public void updateVenueWithSessionMethod(Venue venue) {
		
	}


}
