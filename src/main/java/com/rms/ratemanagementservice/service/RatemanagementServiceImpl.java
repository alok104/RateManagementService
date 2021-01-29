package com.rms.ratemanagementservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.ratemanagementservice.model.Rate;
import com.rms.ratemanagementservice.repo.RatemanagementRepository;

@Service
public class RatemanagementServiceImpl implements RateManagementService {

	@Autowired
	private RatemanagementRepository ratemanagementRepo;
	
	@Override
	public Optional<Rate> getRate(Long rateId) {
		return ratemanagementRepo.findById(rateId);
	}

	@Override
	public void addRate(Rate rate) {
		ratemanagementRepo.save(rate);
	}

	@Override
	public void updateRate(Rate rate) {
		if(rate == null) {
			
		} 
		if(rate.getRateId() == null) {
			
		}
		
		ratemanagementRepo.save(rate);
		
	}

	@Override
	public void deleteRate(Long rateId) {
		ratemanagementRepo.deleteById(rateId);
		
	}

}
