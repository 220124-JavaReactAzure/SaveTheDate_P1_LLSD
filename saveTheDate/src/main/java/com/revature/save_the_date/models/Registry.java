package com.revature.save_the_date.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Registry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="registry_id")
	private String registry_id;
	
	@Column(name="item")
	private List<String> registry_item;
	
	//getters and setters

	public String getRegistry_id() {
		return registry_id;
	}

	public void setRegistry_id(String registry_id) {
		this.registry_id = registry_id;
	}

	public List<String> getRegistry_item() {
		return registry_item;
	}

	public void setRegistry_item(List<String> registry_item) {
		this.registry_item = registry_item;
	}

}

