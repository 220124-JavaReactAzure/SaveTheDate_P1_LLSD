package com.revature.save_the_date.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.save_the_date.hibernate.util.HibernateUtil;
import com.revature.save_the_date.models.Guest;

public class GuestDAO {

	public boolean addWedding(Guest guest) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(guest);
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Guest> getAllGuests() {
		return null;
	}

	public Guest getGuestById(int id) {
		return null;
	}

	public void updateGuestWithSessionMethod(Guest guest) {

	}

}
