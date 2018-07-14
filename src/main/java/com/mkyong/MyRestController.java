/**
 * 
 */
package com.mkyong;

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


	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome() {
		return "my rest api";
	}
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String welcomeByName(@RequestParam String name) {
		return "Hello" + name;
	}

}
