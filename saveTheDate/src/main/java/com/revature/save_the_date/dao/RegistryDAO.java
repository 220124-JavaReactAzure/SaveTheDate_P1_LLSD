package com.revature.save_the_date.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.save_the_date.hibernate.util.HibernateUtil;
import com.revature.save_the_date.models.Registry;

public class RegistryDAO {

	public boolean addRegistry(Registry registry) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(registry);
			transaction.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			HibernateUtil.closeSession();

			return false;
		}
	}

	public List<Registry> getAllRegistry() {
		return null;
	}

	public Registry getRegistryById(int id) {
		return null;
	}

	public void updateRegistryWithSessionMethod(Registry registry) {

	}

}
