package com.anu.app;

import java.util.Map;




public class ATMDetails {
	
	private Map<String, Integer> currDenominatorMap;

	public ATMDetails(Builder builder) {
		this.currDenominatorMap = builder.currDenominatorMap;
	}

	public Map<String, Integer> getCurrDenominator() {
		return currDenominatorMap;
	}

	public void setCurrDenominator(Map<String, Integer> currDenominatorMap) {
		this.currDenominatorMap = currDenominatorMap;
	}
	
		
	public static Builder newBuilder(){
		return new Builder();
	}
	
	public static class Builder{
		private Map<String, Integer> currDenominatorMap;
		
		private Builder(){}
		
		public Builder withCurrentDenom(Map<String, Integer> currDenominatorMap){
			this.currDenominatorMap = currDenominatorMap;
			return this;
		}
		
		
		
		public ATMDetails build(){
			return new ATMDetails(this);
		}
		
		
	}

}
