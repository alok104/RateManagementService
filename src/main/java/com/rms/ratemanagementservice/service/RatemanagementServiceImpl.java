package com.rms.ratemanagementservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.ratemanagementservice.exception.CommonException;
import com.rms.ratemanagementservice.model.Rate;
import com.rms.ratemanagementservice.repo.RatemanagementRepository;

@Service
public class RatemanagementServiceImpl implements RateManagementService {

    Logger logger = LoggerFactory.getLogger(RatemanagementServiceImpl.class);

	@Autowired
	private RatemanagementRepository ratemanagementRepo;
	
	@Override
	public Optional<Rate> getRate(Long rateId) {
		return ratemanagementRepo.findById(rateId);
	}

	@Override
	public void addRate(Rate rate) {
		ratemanagementRepo.save(rate);
		logger.info("Rate created for id {}", rate.getRateId());
	}

	@Override
	public void updateRate(Rate rate) {
		if(rate.getRateId() != null) {
			Optional<Rate> previousRate = getRate(rate.getRateId());
			if(previousRate.isPresent()) {
				Rate rateToUpdate = previousRate.get();
				rateToUpdate.setAmount(rate.getAmount());
				rateToUpdate.setRateDescription(rate.getRateDescription());
				rateToUpdate.setRateEffectiveDate(rate.getRateEffectiveDate());
				rateToUpdate.setRateExpirationDate(rate.getRateExpirationDate());
				ratemanagementRepo.save(rateToUpdate);
				logger.info("Rate updated for id {}", rate.getRateId());
			} else {
				logger.info("Rate Not found for id {}", rate.getRateId());
				throw new CommonException("Rate Not found");
			}
		}
		
	}

	@Override
	public void deleteRate(Long rateId) {
		ratemanagementRepo.deleteById(rateId);
		logger.info("Rate deleted for id {}", rateId);
		
	}

}
