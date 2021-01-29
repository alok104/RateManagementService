package com.rms.ratemanagementservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "rate")
public class Rate {
	@Id
	private Long rateId;
	private String rateDescription;
	
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date rateEffectiveDate;
    
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date rateExpirationDate;
    
	private Integer amount;
	
	public Long getRateId() {
		return rateId;
	}
	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}
	public String getRateDescription() {
		return rateDescription;
	}
	public void setRateDescription(String rateDescription) {
		this.rateDescription = rateDescription;
	}
	public Date getRateEffectiveDate() {
		return rateEffectiveDate;
	}
	public void setRateEffectiveDate(Date rateEffectiveDate) {
		this.rateEffectiveDate = rateEffectiveDate;
	}
	public Date getRateExpirationDate() {
		return rateExpirationDate;
	}
	public void setRateExpirationDate(Date rateExpirationDate) {
		this.rateExpirationDate = rateExpirationDate;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}
