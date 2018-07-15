package com.mkyong;

import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    public Double checkBalance(String AccNbr);
    public void withdrawAmount(long amt);

}
