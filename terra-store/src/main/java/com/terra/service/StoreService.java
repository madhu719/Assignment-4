package com.terra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terra.model.Store;
import com.terra.repo.StoreRepository;


@Service
public class StoreService {
	
	@Autowired
	StoreRepository repository;

	public Store saveStore(Store store) {
		Store stored=repository.save(store);
		return stored;
	}

	public List<Store> getAllStoresForGivenPincode(String pinCode) {
		return repository.findByPincode(pinCode);
	}

}
