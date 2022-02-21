package com.revature.save_the_date.services;

import java.util.List;

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

	public List<Wedding> getAllWedding() {
		return null;
	}

	public Wedding getWeddingById(int id) {
		return null;
	}

	public void updateWeddingWithSessionMethod(Wedding wedding) {

	}

	public void updateWeddingWithHQL(Wedding wedding) {

	}

}
