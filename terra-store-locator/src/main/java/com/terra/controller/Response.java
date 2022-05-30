package com.terra.controller;

import java.util.List;

public class Response {

	private String message;
	
	private List<Store> stores;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}
	
	
	
}
