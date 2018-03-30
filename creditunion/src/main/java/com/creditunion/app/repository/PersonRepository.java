package com.creditunion.app.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.creditunion.app.domain.Person;

@Repository
public class PersonRepository {
	
	private static List<Person> persons = new ArrayList<>(Arrays.asList(
			new Person("Ram","Sharma","123-45-0010","98765",true),
			new Person("Shyam","Gupta","123-56-0020","98764",false),
			new Person("Tina","Goel","123-56-0030","98763",true),
			new Person("Rina","Shah","123-56-0040","98761",false)
			));
		
	public Person findPersonBySSN(String ssn){
		return persons.stream().filter(p -> p.getSsn().equals(ssn)).findFirst().orElse(null);
	}
	
}
