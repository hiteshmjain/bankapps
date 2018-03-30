package com.bank.app.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.app.domain.Customer;
import com.bank.app.services.CustomerServices;
import com.bank.app.vo.CustomerRequestVO;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired 
	CustomerServices customerServices;
	
	
	@PostMapping(value="/addCustomer", consumes="application/json")
	public String createCustomer(@RequestBody CustomerRequestVO customerRequestVO, HttpServletResponse response){
		
		String id =  customerServices.createCustomer(customerRequestVO);
		if(id!=null){
			response.setStatus(HttpServletResponse.SC_CREATED);
		}else{
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		return id;
	}

	@GetMapping(value="/getCustomer", consumes="application/json")
	public Customer createCustomer(@RequestParam String id, HttpServletResponse response){
	
		Customer customer = customerServices.findCustomerById(id);
		if(customer==null){
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return customer;
	}
}
