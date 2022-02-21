package com.revature.save_the_date.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.save_the_date.hibernate.util.HibernateUtil;
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
