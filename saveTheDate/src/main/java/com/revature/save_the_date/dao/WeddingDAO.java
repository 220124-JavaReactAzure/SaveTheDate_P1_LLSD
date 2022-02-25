package com.revature.save_the_date.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.save_the_date.hibernate.util.HibernateUtil;
import com.revature.save_the_date.models.Guest;
import com.revature.save_the_date.models.Wedding;

public class WeddingDAO {
	
	public boolean addWedding(Wedding wedding) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(wedding);
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			HibernateUtil.closeSession();

			return false;
		}
	}
	
	public List<Wedding> getAllWeddings(){
		try {
			Session session = HibernateUtil.getSession();
			List<Wedding> weddings = session.createQuery("from Wedding").list();
			return weddings;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public Wedding getWeddingById(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Wedding wedding = session.get(Wedding.class, id);
			return wedding;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public void updateWeddingWithSessionMethod(Wedding wedding) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.merge(wedding);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		
	}
	public void updateWeddingWithHQL(Wedding wedding) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();


			session.merge(wedding);
			transaction.commit();
			Query query = (Query) session.createQuery("update Wedding set wedding_date='" + wedding.getWedding_date() + "', wedding_venue='" + wedding.getWedding_venue()
			+ "', wedding_id='" + wedding.getWedding_id());
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void removeWedding(Wedding wedding) {
		
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			String sql = "delete Wedding where wedding_id ='" + wedding.getWedding_id() + "'";
			Query<Wedding> query = session.createQuery(sql);
			query.executeUpdate();


			
			transaction.commit();
		
			
		} catch (HibernateException | IOException e) {
			e.printStackTrace();

			
			
		} finally {
			HibernateUtil.closeSession();
		}
	}



}
