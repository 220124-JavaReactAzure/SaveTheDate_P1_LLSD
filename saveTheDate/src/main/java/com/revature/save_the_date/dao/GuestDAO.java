package com.revature.save_the_date.dao;

import java.io.IOException;
import java.util.List;


import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.postgresql.core.Query;


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
		} 
	}

	public List<Guest> getAllGuests() {
		try {
			Session session = HibernateUtil.getSession();
			List<Guest> guests = session.createQuery("from Guest").list();
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
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.merge(guest);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}

	}

	//TODO: IMPLEMENT PROPERLY

	public void updateGuestWithHQL(Guest guest) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();

			Query query = (Query) session.createQuery("update Guest set email='" + guest.getEmail() + "', fname='"
					+ guest.getFname() + "', lname='" + guest.getLname() + "', plus_one='" 
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
