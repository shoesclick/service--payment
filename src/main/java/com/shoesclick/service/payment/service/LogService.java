package com.shoesclick.service.payment.service;


import com.shoesclick.service.payment.entity.Log;
import com.shoesclick.service.payment.repository.LogRepository;
import org.springframework.stereotype.Service;

@Service
public class LogService {

	private final LogRepository logRepository;

	public LogService(LogRepository logRepository) {
		this.logRepository = logRepository;
	}


	public void save(Log log) {
		logRepository.save(log);
	}
	

}