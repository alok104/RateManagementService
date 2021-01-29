package com.rms.ratemanagementservice.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rms.ratemanagementservice.model.Rate;
import com.rms.ratemanagementservice.service.RateManagementService;
import com.rms.ratemanagementservice.util.RateValidator;

@RestController
@RequestMapping("/surcharge/v1")
public class RateManagementController {
	
    Logger logger = LoggerFactory.getLogger(RateManagementController.class);

	@Autowired
	private RateManagementService ratemanagementService;
	
	@Autowired
	private RateValidator validator;
	
	@HystrixCommand(fallbackMethod = "reliable")
	@GetMapping("/rate")
	public Optional<Rate> getRate(@RequestParam(required= true) Long rateId) {
		logger.info("Request received for getRate() with id {}",rateId);
		return ratemanagementService.getRate(rateId);
	}
	
	@HystrixCommand(fallbackMethod = "reliable")
	@PostMapping("/rate")
	public ResponseEntity<?> addRate(@RequestBody(required= true) Rate rate) {
		validator.validateRate(rate);
		logger.info("Request received for addRate() with id {}", rate.getRateId());
		ratemanagementService.addRate(rate);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@HystrixCommand(fallbackMethod = "reliable")
	@PutMapping("/rate")
	public ResponseEntity<?> updateRate(@RequestBody(required= true) Rate rate) {
		validator.validateRate(rate);
		logger.info("Request received for updateRate() with id {}",rate.getRateId());
		ratemanagementService.updateRate(rate);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@HystrixCommand(fallbackMethod = "reliable")
	@DeleteMapping("/rate")
	public ResponseEntity<?> deleteRate(@RequestParam(required= true) Long rateId) {
		logger.info("Request received for deleteRate() with id {}",rateId);
		ratemanagementService.deleteRate(rateId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	public String reliable() {
		  return "Please retry after sometime";
	 }

}
