package com.cg.oam.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.oam.dto.CustomerDto;
import com.cg.oam.dto.SuccessMessage;
import com.cg.oam.entities.Customer;
import com.cg.oam.exceptions.ValidateCustomerException;
import com.cg.oam.service.CustomerServiceImpl;

@RestController
public class CustomerRestController {

	@Autowired
	CustomerServiceImpl customerService;
	
	@PostMapping("/addcustomer")
	public SuccessMessage addCustomer(@Valid @RequestBody CustomerDto custDto, BindingResult br ) throws ValidateCustomerException {
		System.out.println("Add customer");
		
		if(br.hasErrors())
			throw new ValidateCustomerException(br.getFieldErrors());
		
		int cid = customerService.addCustomer(custDto);
		
		return new SuccessMessage("customer added with Customer ID " + cid);
		
	}
		
	
}