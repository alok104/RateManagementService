package com.rms.ratemanagementservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rms.ratemanagementservice.model.Rate;
import com.rms.ratemanagementservice.service.RateManagementService;
import com.rms.ratemanagementservice.util.RateValidator;

@RestController
@RequestMapping("/v1/surcharge")
public class RateManagementController {
	
	@Autowired
	private RateManagementService ratemanagementService;
	
	@Autowired
	private RateValidator validator;
	
	@GetMapping("/rate")
	public Optional<Rate> getRate(@RequestParam(required= true) Long rateId) {
		return ratemanagementService.getRate(rateId);
	}
	
	@PostMapping("/rate")
	public ResponseEntity<?> addRate(@RequestBody(required= true) Rate rate) {
		validator.validateRate(rate);
		ratemanagementService.addRate(rate);
		return null;
	}
	
	@PutMapping("/rate")
	public ResponseEntity<?> updateRate(@RequestBody(required= true) Rate rate) {
		validator.validateRate(rate);
		ratemanagementService.updateRate(rate);
		return null;
	}
	
	@DeleteMapping("/rate")
	public ResponseEntity<?> deleteRate(@RequestParam(required= true) Long rateId) {
		ratemanagementService.deleteRate(rateId);
		return null;
	}

}
