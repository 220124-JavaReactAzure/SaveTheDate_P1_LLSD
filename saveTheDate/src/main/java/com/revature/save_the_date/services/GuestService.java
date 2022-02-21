package com.revature.save_the_date.services;

import java.util.List;

import com.revature.save_the_date.dao.GuestDAO;
import com.revature.save_the_date.models.Guest;

public class GuestService {
	private final GuestDAO guestDAO;

	public GuestService(GuestDAO guestDAO) {
		super();
		this.guestDAO = guestDAO;
		// TODO Auto-generated constructor stub
	}
	
	public boolean addGuest(Guest guest) {
		return guestDAO.addGuest(guest);
	}
	
	public List<Guest> getAllGuests() {
		return null;
	}

	public Guest getGuestById(int id) {
		return null;
	}

	public void updateGuestWithSessionMethod(Guest guest) {

	}

	public void updateGuestWithHQL(Guest guest) {

	}

}
