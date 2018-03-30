package com.bank.app.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bank.app.domain.Customer;

@Repository
public class CustomerRepository {
	
	private static List<Customer> customers = new ArrayList<>();
		
	public Customer findCustomerById(String id){
		return customers.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
	}
	
	public String createCustomer(Customer customer){
		customers.add(customer);
		return customer.getId();
	}
}
