package com.mkyong;

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
	
	@PostConstruct
	public void init(){
		LOGGER.info("init called");
		accountMap.put("01001", AccountDetails.newBuilder().withAccountNumber("01001").withBalance(2738.59).build());
		accountMap.put("01002", AccountDetails.newBuilder().withAccountNumber("01002").withBalance(23.00).build());
		accountMap.put("01003", AccountDetails.newBuilder().withAccountNumber("01003").withBalance(0.00).build());
		LOGGER.info("account map {}", accountMap);
	}
	
	public AccountDetails getAccountDetailsByNumber(String accountNumber){
		return accountMap.get(accountNumber);
	}

}
