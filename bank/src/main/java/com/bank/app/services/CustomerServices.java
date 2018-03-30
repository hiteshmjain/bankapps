package com.bank.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.app.domain.Customer;
import com.bank.app.repository.CustomerRepository;
import com.bank.app.vo.CustomerRequestVO;
import com.bank.app.vo.PersonRequestVO;
import com.bank.app.vo.PersonResponseVO;


@Service
public class CustomerServices {

	@Autowired
	CustomerRepository customerRepository;
	
	public Customer findCustomerById(String id){
		return customerRepository.findCustomerById(id);
	}
	
	public String createCustomer(CustomerRequestVO customerRequestVO){
		
		String id = null;
		String status = "";
		
		PersonRequestVO personRequestVO = new PersonRequestVO(customerRequestVO.getFirstName(), customerRequestVO.getLastName(), customerRequestVO.getSsn(), customerRequestVO.getZipCode());
		
		status = restInvokerToCheckEligibility(personRequestVO);
		
		if(status!=null && status.equals("APPROVED"))
	    	id = customerRepository.createCustomer(new Customer(customerRequestVO.getFirstName(), customerRequestVO.getLastName(), customerRequestVO.getSsn(), customerRequestVO.getZipCode(), customerRequestVO.getEmail()));  
		
	    return id;
	    
	}
	
	
	private String restInvokerToCheckEligibility(PersonRequestVO personRequestVO){
		
		String status=null;
		
		final String uri = "http://localhost:8080/financial-eligibility";//Hardcoded to be add in the application properties
		RestTemplate restTemplate = new RestTemplate();

	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.set("Content-Type", "application/json");
	    httpHeaders.set("Authorization", "Bearer 123XXX456");
	    httpHeaders.set("X-Request-Id", "CC4455DD");
	 	    	    
	    HttpEntity <PersonRequestVO> httpEntity = new HttpEntity <PersonRequestVO> (personRequestVO, httpHeaders);

	    PersonResponseVO personResponseVO = restTemplate.postForObject(uri, httpEntity, PersonResponseVO.class);
	    status = personResponseVO.getError();
		
		return status;   
	}
}
