package com.rms.ratemanagementservice.util;

import org.springframework.stereotype.Component;

import com.rms.ratemanagementservice.exception.CommonException;
import com.rms.ratemanagementservice.model.Rate;

@Component
public class RateValidator {
	public void validateRate(Rate rate) {
		if(rate == null) {
			throw new CommonException("rate field required");
		}
		if(rate.getRateId() == null) {
			throw new CommonException("rateId required");
		}
		if(rate.getAmount() == null) {
			throw new CommonException("amount required");	
		}
		if(rate.getRateDescription() == null) {
			throw new CommonException("rateDescription required");
		}
		if(rate.getRateEffectiveDate() == null) {
			throw new CommonException("rateEffectiveDate required");
		}
		if(rate.getRateExpirationDate() == null) {
			throw new CommonException("rateExpirationDate required");
		}
	}
}
