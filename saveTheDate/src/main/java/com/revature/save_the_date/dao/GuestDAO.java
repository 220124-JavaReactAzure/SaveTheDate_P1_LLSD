package com.revature.save_the_date.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.save_the_date.hibernate.util.HibernateUtil;
import com.revature.save_the_date.models.Guest;

public class GuestDAO {

	public boolean addGuest(Guest guest) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(guest);
			transaction.commit();

			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			HibernateUtil.closeSession();
			return false;
		}
	}

	public List<Guest> getAllGuests() {
		return null;
	}

	public Guest getGuestById(int id) {
		return null;
	}

	public Guest verify(String email, String password) {
		try {
			Session session = HibernateUtil.getSession();
			String sql = "select from guest where (email,password) values ? ?";

			Transaction transaction = session.beginTransaction();
			transaction.commit();
			Query<Guest> query = session.createQuery(sql);
			Guest results = query.getSingleResult();
			if (results != null) {

				HibernateUtil.closeSession();
				return results;
			}else {
				HibernateUtil.closeSession();
				return results;
			}


		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public void updateGuestWithSessionMethod(Guest guest) {

	}

}
