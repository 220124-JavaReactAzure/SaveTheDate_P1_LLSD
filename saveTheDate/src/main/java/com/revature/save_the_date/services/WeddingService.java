package com.revature.save_the_date.services;

import java.util.List;

import javax.persistence.EntityManager;

import com.revature.save_the_date.dao.WeddingDAO;
import com.revature.save_the_date.models.Wedding;

public class WeddingService {
	private final WeddingDAO weddingDAO;

	public WeddingService(WeddingDAO weddingDAO) {
		this.weddingDAO = weddingDAO;
	}

	public boolean addWedding(Wedding wedding) {
		return weddingDAO.addWedding(wedding);
	}

	public List<Wedding> getAllWeddings() {
		return weddingDAO.getAllWeddings();
	}

	public Wedding getWeddingById(int id) {
		return weddingDAO.getWeddingById(id);
	}

	public void updateWeddingWithSessionMethod(Wedding wedding) {
		weddingDAO.updateWeddingWithSessionMethod(wedding);
	}

	public void updateWeddingWithHQL(Wedding wedding) {
		weddingDAO.updateWeddingWithHQL(wedding);
	}

	public void removeWedding(Wedding wedding) {
		weddingDAO.removeWedding(wedding);
	}
}
