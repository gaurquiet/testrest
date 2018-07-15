/**
 * 
 */
package com.mkyong;

import java.util.HashMap;
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


	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome() {
		return "my rest api";
	}
	
	@RequestMapping(value="/checkBalance", method=RequestMethod.GET)
	public Double checkBalance(@RequestParam String AccountNumber) {
		return accountService.checkBalance(AccountNumber);
	}
	
	@RequestMapping(value="/withdrawAmount", method=RequestMethod.POST)
	public Map<String, String> withdrawAmount(@RequestParam String AccountNumber) {
		return new HashMap<>();
	}

}
