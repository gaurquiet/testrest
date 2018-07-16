/**
 * 
 */
package com.anu.app;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaurq
 *
 */
@RestController
@RequestMapping("/rest")
public class MyRestController {
	
	@Autowired
	private AccountService accountService;

	@Autowired
	private ATMService atmService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome() {
		return "my rest api";
	}
	
	@RequestMapping(value="/checkBalance", method=RequestMethod.GET)
	public Double checkBalance(@RequestParam String accountNumber) {
		return accountService.checkBalance(accountNumber);
	}
	
	@RequestMapping(value="/withdrawAmount", method=RequestMethod.GET)
	public Map<String, Integer> withdrawAmount(@RequestParam String accountNumber, @RequestParam long amount) {
		return atmService.withdrawAmount(accountNumber, amount);
	}
	
	@RequestMapping(value="/replenish", method=RequestMethod.GET)
	public Map<String, Integer> replenishATM() {
		return atmService.replenishATM();
	}

}
