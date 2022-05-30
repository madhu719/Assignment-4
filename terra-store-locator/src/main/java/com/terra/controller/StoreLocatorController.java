package com.terra.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/storelocator")
public class StoreLocatorController {
	
	private static final Logger logger = LoggerFactory.getLogger(StoreLocatorController.class);
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/{pincode}")
	private Response getStoresForGivenPincode(@PathVariable("pincode") String pincode) {
		if (restTemplate == null) {
			restTemplate = new RestTemplate();
		}
		ResponseEntity<Response> response = null;
		try {
			response = restTemplate.getForEntity(new URI("http://localhost:10005/store/" + pincode),
					Response.class);
		} catch (RestClientException | URISyntaxException e) {
			logger.debug("Unable to fetch information, Reason :" + e.getMessage(),
					e.getMessage());
		}
		if (response != null) {
			return response.getBody();
		} else {
			return null;
		}
	}
}
