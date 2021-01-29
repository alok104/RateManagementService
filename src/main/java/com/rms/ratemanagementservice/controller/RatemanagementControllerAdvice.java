package com.rms.ratemanagementservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rms.ratemanagementservice.constant.Constants;
import com.rms.ratemanagementservice.error.ApiError;
import com.rms.ratemanagementservice.exception.CommonException;

@ControllerAdvice
public class RatemanagementControllerAdvice {
	@ExceptionHandler({ CommonException.class })
	public ResponseEntity<?> handleApplicationException(CommonException ex) {
		ApiError apiError = new ApiError();
		apiError.setMessage(ex.getMessage());
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<?> handleException(Exception ex) {
		ApiError apiError = new ApiError();
		apiError.setMessage(Constants.ERROR_MESSAGE);
		apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
