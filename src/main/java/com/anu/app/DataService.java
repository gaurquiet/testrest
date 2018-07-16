package com.anu.app;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DataService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DataService.class);
	
	private Map<String, AccountDetails> accountMap = new HashMap<>();
	private Map<String, Integer> currDenominatorMap = new HashMap<>();
	
	
	@PostConstruct
	public void init(){
		LOGGER.info("init called");
		accountMap.put("01001", AccountDetails.newBuilder().withAccountNumber("01001").withBalance(2738.59).build());
		accountMap.put("01002", AccountDetails.newBuilder().withAccountNumber("01002").withBalance(23.00).build());
		accountMap.put("01003", AccountDetails.newBuilder().withAccountNumber("01003").withBalance(0.00).build());
		//Denominator 5 has 10 number count in ATM
		currDenominatorMap.put("5", 10);
		currDenominatorMap.put("10", 10);
		currDenominatorMap.put("20", 10);
		currDenominatorMap.put("50", 10);
		//ATMDetails.newBuilder().withCurrentDenom(currDenominatorMap);
		LOGGER.info("account map {}", accountMap);
		LOGGER.info("Denominator map {}", currDenominatorMap);
	}
	
	public AccountDetails getAccountDetailsByNumber(String accountNumber){
		return accountMap.get(accountNumber);
	}
	
	public ATMDetails getAtmDetails(){
		return ATMDetails.newBuilder().withCurrentDenom(currDenominatorMap).build();
	}

}
