/**
 * 
 */
package com.anu.app;

import java.util.Map;

/**
 * @author gaurq
 *
 */
public interface ATMService {
	
	public Map<String, Integer> replenishATM();
	public Map<String, Integer> withdrawAmount(String AccNbr, long amount);
}
