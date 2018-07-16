package com.anu.app;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface AccountService {

    public Double checkBalance(String AccNbr);
    
    public Map<String, Integer> replenishATM(); 
}
