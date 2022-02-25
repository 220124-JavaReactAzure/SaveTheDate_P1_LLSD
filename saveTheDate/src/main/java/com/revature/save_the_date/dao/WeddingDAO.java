package com.revature.save_the_date.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.save_the_date.hibernate.util.HibernateUtil;
import com.revature.save_the_date.models.Wedding;

public class WeddingDAO {
	
	public boolean addWedding(Wedding wedding) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(wedding);
			transaction.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			HibernateUtil.closeSession();

			return false;
		}
	}
	
	public List<Wedding> getAllWeddings(){
		return null;
	}
	
	public Wedding getWeddingById(int id) {
		return null;
	}
	
	public void updateWeddingWithSessionMethod(Wedding wedding) {
		
	}

}
