package com.terra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.terra.model.Response;
import com.terra.model.Store;
import com.terra.service.StoreService;


@RestController
@RequestMapping("/store")
public class StoreController {

	@Autowired
	StoreService storeService;

	@PostMapping
	public ResponseEntity<Store> createStore(@RequestBody Store store) {
		System.out.println("store:::"+store.toString());
		return new ResponseEntity<Store>(storeService.saveStore(store), HttpStatus.OK);
	}

	@GetMapping("/{pinCode}")
	public ResponseEntity<Response> getStores(@PathVariable String pinCode) {
		
		List<Store> listOfStores = storeService.getAllStoresForGivenPincode(pinCode);
		Response response=new Response();
		
		if (!listOfStores.isEmpty()) {	
			response.setStores(listOfStores);
			response.setMessage("SUCESS");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setMessage("No stores found");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}

	}
}
