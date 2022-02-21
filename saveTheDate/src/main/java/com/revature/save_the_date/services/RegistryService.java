package com.revature.save_the_date.services;

import java.util.List;

import com.revature.save_the_date.dao.RegistryDAO;
import com.revature.save_the_date.models.Registry;

public class RegistryService {
	private final RegistryDAO registryDAO;

	public RegistryService(RegistryDAO registryDAO) {
		this.registryDAO = registryDAO;	
		
	}
	public boolean addRegistry(Registry registry) {
		return registryDAO.addRegistry(registry);
	}
	
	public List<Registry> getAllRegistry(){
		return null;
	}
	
	public Registry getRegistryById(int id) {
		return null;
	}
	
	public void updateRegistryWithSessionMethod(Registry registry) {
		
	}
	
	public void updateRegistryWithHQL(Registry registry) {
		
	}

}
