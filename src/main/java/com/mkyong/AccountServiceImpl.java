package com.mkyong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl  implements AccountService {
	
	@Autowired
	private DataService dataService;

    @Override
    public void withdrawAmount(long amount) {
        if(amount%5!=0){
            System.out.println("Please enter the amount in multiples of 10");
        }

    }

    // The checkID method determines if acctNum is a valid account number
    // and pwd is the correct password for the account.  If the account information
    // is valid, the method returns the current account balance, as a string.
    // If the account information is invalid, the method returns the string "error".
    @Override
    public Double checkBalance(String acctNum){
        return dataService.getAccountDetailsByNumber(acctNum).getBalance();
    }
}
