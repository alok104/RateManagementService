package com.rms.ratemanagementservice.helper;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

import com.rms.ratemanagementservice.model.Rate;

public class RatemanagementDTO {
	public Optional<Rate> randomRequest() {
		Rate rate = new Rate();
		
		rate.setRateId(generateRate());
		rate.setRateDescription("some rate");
		rate.setRateEffectiveDate(new Date());
		rate.setRateExpirationDate(new Date());
		rate.setAmount(2424);
		return Optional.ofNullable(rate);  
	}
	
	public Long generateRate() {
		Random rendomNumber = new Random();
		int low = 55500;
		int high = 123000;
		int result = rendomNumber.nextInt(high-low) + low;
		return (long)result;
	}
}
