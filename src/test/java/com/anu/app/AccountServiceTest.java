package com.anu.app;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

public class AccountServiceTest {
	
	@InjectMocks
	private AccountServiceImpl subject;
	
	@Mock
	private DataService dataService;
	
	@Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testCheckBalance(){
		AccountDetails mockedDetails = mock(AccountDetails.class);
		String accountNumber = "010001";
		when(mockedDetails.getAccountNumber()).thenReturn(accountNumber);
		when(mockedDetails.getBalance()).thenReturn(1.234);
		when(dataService.getAccountDetailsByNumber(accountNumber)).thenReturn(mockedDetails);
		Double balance = subject.checkBalance(accountNumber);
		Assert.notNull(balance);
	}
	

}
