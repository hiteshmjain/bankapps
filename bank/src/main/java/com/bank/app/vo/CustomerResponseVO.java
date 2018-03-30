package com.bank.app.vo;

public class CustomerResponseVO {

	private String firstName;
	
	private String lastName;
	
	private boolean eligibility;
	
	private String error="DENIED";

	public CustomerResponseVO(){
		//Blank Constructor
	}
	
	public CustomerResponseVO(String firstName, String lastName, boolean eligibility, String error){
		this.firstName = firstName;
		this.lastName = lastName;
		this.eligibility = eligibility;
		this.error=error;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isEligibility() {
		return eligibility;
	}

	public void setEligibility(boolean eligibility) {
		this.eligibility = eligibility;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
	
	
}
