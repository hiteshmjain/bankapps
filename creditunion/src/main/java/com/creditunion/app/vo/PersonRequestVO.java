package com.creditunion.app.vo;

import com.creditunion.app.domain.Person;

public class PersonRequestVO {

	private String firstName;
	
	private String lastName;
	
	private String ssn;
	
	private String zipCode;

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
	
	public PersonResponseVO isEligible(Person person){
		PersonResponseVO personResponseVo = null;
		if(person!=null && 
		   person.isEligibility() && 
		   this.getFirstName().equals(person.getFirstName()) &&
		   this.getLastName().equals(person.getLastName())){	
		    personResponseVo = new PersonResponseVO(person.getFirstName(),person.getLastName(),person.isEligibility(), "APPROVED");	
		}
		else{
			personResponseVo = new PersonResponseVO();
		}
		return personResponseVo;
	}
			
}
