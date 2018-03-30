package com.creditunion.app.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.creditunion.app.domain.Person;
import com.creditunion.app.security.SecuirtyService;
import com.creditunion.app.services.PersonServices;
import com.creditunion.app.vo.PersonRequestVO;
import com.creditunion.app.vo.PersonResponseVO;

@RestController
public class PersonController {
	
	@Autowired 
	PersonServices personServices;
	
	
	@PostMapping(value="/financial-eligibility", consumes="application/json")
	public PersonResponseVO checkEligibility(@RequestBody PersonRequestVO personRequestVO, 
			@RequestHeader(value="Authorization", required = false) String bearerToken,
			@RequestHeader(value="X-Request-ID", required = false) String xRequestId,
			HttpServletResponse response){
		
		PersonResponseVO personResponseVO = new PersonResponseVO();
		response.setHeader("X-Request-ID", xRequestId);
		
		if(SecuirtyService.validateToken(bearerToken)){
			Person person = personServices.findPersonBySSN(personRequestVO.getSsn());
			personResponseVO = personRequestVO.isEligible(person);
			response.setStatus(HttpServletResponse.SC_OK);
		}else{
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
		return personResponseVO;
	}


}
