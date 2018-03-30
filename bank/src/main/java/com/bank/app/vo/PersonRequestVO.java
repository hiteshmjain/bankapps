package com.bank.app.vo;

public class PersonRequestVO {

	private String firstName;
	
	private String lastName;
	
	private String ssn;
	
	private String zipCode;

	public PersonRequestVO(String firstName, String lastName, String ssn, String zipCode){
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn= ssn;
		this.zipCode = zipCode;
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
	
}
