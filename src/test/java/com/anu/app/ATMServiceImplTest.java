package com.anu.app;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ATMServiceImplTest {
    @InjectMocks
    private ATMServiceImpl subject;

    @Mock
    private DataService dataService;
    @Mock
    private AccountService accountService;

    @Before
    public void initMocks(){

        MockitoAnnotations.initMocks(this);
        Map<String, Integer> currDenominatorMap = new HashMap<>();
        currDenominatorMap.put("5", 10);
        currDenominatorMap.put("10", 10);
        currDenominatorMap.put("20", 10);
        currDenominatorMap.put("50", 10);
        ATMDetails atmDetails = ATMDetails.newBuilder().withCurrentDenom(currDenominatorMap).build();
        when(dataService.getAtmDetails()).thenReturn(atmDetails);
    }

    @Test
    public void testCheckBalance(){
        when(accountService.checkBalance("01001")).thenReturn(2000.5);
        Map<String, Integer> noteMap = subject.withdrawAmount("01001", 235);
        Assert.assertEquals("50 note count wrong", new Integer(4), noteMap.get("50"));
        Assert.assertEquals("20 note count wrong", new Integer(1), noteMap.get("20"));
        Assert.assertEquals("10 note count wrong", new Integer(1), noteMap.get("10"));
        Assert.assertEquals("5 note count wrong", new Integer(1), noteMap.get("5"));
    }

    @Test
    public void testCheckBalanceFor5(){
        when(accountService.checkBalance("01001")).thenReturn(2000.5);
        Map<String, Integer> noteMap = subject.withdrawAmount("01001", 5);
        Assert.assertNull("50 note count wrong", noteMap.get("50"));
        Assert.assertNull("20 note count wrong", noteMap.get("20"));
        Assert.assertNull("10 note count wrong", noteMap.get("10"));
        Assert.assertEquals("5 note count wrong", new Integer(1), noteMap.get("5"));
    }
}
