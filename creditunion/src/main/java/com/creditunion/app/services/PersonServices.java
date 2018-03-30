package com.creditunion.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditunion.app.domain.Person;
import com.creditunion.app.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository personRepository;
	
	public Person findPersonBySSN(String ssn){
		return personRepository.findPersonBySSN(ssn);
	}
	
}
