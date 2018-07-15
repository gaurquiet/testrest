package com.mkyong;

public class AccountDetails {
	
	private String accountNumber;
	private Double balance;
	
	public AccountDetails(Builder builder) {
		this.accountNumber = builder.accountNumber;
		this.balance = builder.balance;
	}
	
	public static Builder newBuilder(){
		return new Builder();
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public static class Builder{
		private String accountNumber;
		private Double balance;
		
		private Builder(){}
		
		public Builder withAccountNumber(String accNum){
			this.accountNumber = accNum;
			return this;
		}
		
		public Builder withBalance(Double bala){
			this.balance = bala;
			return this;
		}
		
		public AccountDetails build(){
			return new AccountDetails(this);
		}
		
		
	}

}
