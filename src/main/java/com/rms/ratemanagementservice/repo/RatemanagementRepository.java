package com.rms.ratemanagementservice.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rms.ratemanagementservice.model.Rate;

@Repository
public interface RatemanagementRepository extends CrudRepository<Rate, Long> {

}
