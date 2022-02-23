package com.revature.save_the_date.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.TypedQuery;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.save_the_date.models.Guest;
import com.revature.save_the_date.hibernate.util.HibernateUtil;

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
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public List<Guest> getAllGuests() {
		try {
			Session session = HibernateUtil.getSession();
			List<Guest> guests = session.createQuery("FROM guest").list();
			return guests;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public Guest getGuestById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Guest guest = session.get(Guest.class, id);
			return guest;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void updateGuestWithSessionMethod(Guest guest) {
		try {
			Session session = HibernateUtil.getSession();
			// Updates and Deletes always start with a transaction and end with a commit
			Transaction transaction = session.beginTransaction();
			session.merge(guest);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}

	}

	// Not truly implemented

	public void updateGuestWithHQL(Guest guest) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();

			Query query = session.createQuery("update guest set email='" + guest.getEmail() + "', fname='"
					+ guest.getFname() + "', lame='" + guest.getLname() + "', plus_one='" 
					+ guest.getPlus_one() + "', food='" + guest.getFood() + "', plus_one_food'" 
					+ guest.getPlus_one_food() + "', guest_type='" + guest.getGuest_type() 
					+ " WHERE guest_id=" + guest.getGuest_id());
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	/*
	 * Query query = session.
	 * createQuery("update guest set email= :email, first_name= :firstName, last_name= :lastName, year_born=:yearBorn where director_id = :id"
	 * ); //query.setParameter("email", director.getEmail()); query.executeUpdate();
	 * transaction.commit(); } catch (HibernateException | IOException e) {
	 * e.printStackTrace(); } finally { HibernateUtil.closeSession(); }
	 * 
	 * }
	 */
	public void deleteGuest(int id) {
		try {
			Session session = HibernateUtil.getSession();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}