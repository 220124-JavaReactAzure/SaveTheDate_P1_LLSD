package com.revature.save_the_date.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.save_the_date.hibernate.util.HibernateUtil;
import com.revature.save_the_date.models.Registry;

public class RegistryDAO {

	public boolean addRegistry(Registry registry) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(registry);
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
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
