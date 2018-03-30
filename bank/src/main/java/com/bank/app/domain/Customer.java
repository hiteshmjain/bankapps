package com.bank.app.domain;

public class Customer {

	private String id;
	
	private String firstName;
	
	private String lastName;
		
	private String zipCode;
	
	private String email;

	public Customer(String firstName, String lastName, String ssn, String zipCode, String email){
		this.id=zipCode.concat(ssn.substring(7,11));
		this.firstName = firstName;
		this.lastName = lastName;
		this.zipCode = zipCode;
		this.email = email;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
		
}
