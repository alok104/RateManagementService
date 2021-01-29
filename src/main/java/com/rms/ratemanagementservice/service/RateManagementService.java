package com.rms.ratemanagementservice.service;

import java.util.Optional;

import com.rms.ratemanagementservice.model.Rate;

public interface RateManagementService {

	Optional<Rate> getRate(Long rateId);

	void addRate(Rate rate);

	void updateRate(Rate rate);

	void deleteRate(Long rateId);
	
}
