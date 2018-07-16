package com.anu.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ATMServiceImpl implements ATMService {

    @Autowired
    private DataService dataService;

    @Autowired
    private AccountService accountService;


    @Override
    public Map<String, Integer> replenishATM() {
        return dataService.getAtmDetails().getCurrDenominator();
    }

    @Override
    public Map<String, Integer> withdrawAmount(String AccNbr, long amount) {
        Double newBal = null;
        Double currBal = accountService.checkBalance(AccNbr);
        Map<String, Double> map = new HashMap<>();
        if (currBal > amount) {
            newBal = currBal - amount;
            map.put(AccNbr, newBal);
        } else {
            map.put("ERROR: CURRENT BALANCE IS LESS THAN AMOUNT TO BE WITHDRAWN", currBal);
        }

        return withdrawCash(amount).getCurrDenominator();
    }

    private ATMDetails withdrawCash(long amount) {
        Map<String, Integer> currDenoMap = replenishATM();
        Map<String, Integer> withdrawDenomMap = new HashMap<>();
        if (amount >= 20 && amount <= 250) {

            long remainingamount = amount;
            if(amount%5%2 ==0){
                withdrawDenomMap.put("5", 2);
                remainingamount = remainingamount-5*2;
            }else{
                withdrawDenomMap.put("5", 1);
                remainingamount = remainingamount-5*1;
            }
            if (remainingamount % 50 >= 0 && currDenoMap.get("50") > 0) {
                withdrawDenomMap.put("50", (int) (amount / 50));
                remainingamount = remainingamount - (remainingamount / 50) * 50;
                if (remainingamount != 0) {
                    if (remainingamount % 20 >= 0 && currDenoMap.get("20") > 0) {
                        withdrawDenomMap.put("20", (int) (remainingamount / 20));
                        remainingamount = remainingamount - (remainingamount / 20) * 20;
                        if (remainingamount != 0) {
                            if (remainingamount % 10 >= 0 && currDenoMap.get("10") > 0) {
                                withdrawDenomMap.put("10", (int) (remainingamount / 10));
                                remainingamount = remainingamount - (remainingamount / 10) * 10;
                                if (remainingamount != 0) {
                                    if (remainingamount % 5 >= 0 && currDenoMap.get("5") > 0) {
                                        withdrawDenomMap.put("5", (int) (remainingamount / 5));
                                        remainingamount = remainingamount - (remainingamount / 5) * 5;
                                    }
                                }
                            }

                        }
                    }
                }
            }

        }
        return ATMDetails.newBuilder().withCurrentDenom(withdrawDenomMap).build();


    }
}
