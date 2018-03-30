package com.creditunion.app.domain;

public class Person {

	private String firstName;
	
	private String lastName;
	
	private String ssn;
	
	private String zipCode;
	
	private boolean eligibility;

	public Person(String firstName, String lastName, String ssn, String zipCode, boolean eligibility){
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn=ssn;
		this.zipCode = zipCode;
		this.eligibility = eligibility;
		
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public boolean isEligibility() {
		return eligibility;
	}

	public void setEligibility(boolean eligibility) {
		this.eligibility = eligibility;
	}
	
	
	
	
}
