package com.cg.oam.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oam.dto.CustomerDto;
import com.cg.oam.dto.SuccessMessage;
import com.cg.oam.entities.Customer;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.exceptions.ValidateException;
import com.cg.oam.service.CustomerServiceImpl;

@RestController
public class CustomerRestController {

	@Autowired
	CustomerServiceImpl customerService;
	
	@PostMapping("addcustomer")
	public SuccessMessage addCustomer(@Valid @RequestBody CustomerDto custDto, BindingResult br ) throws ValidateException {
		System.out.println("Add customer");
		
		if(br.hasErrors())
			throw new ValidateException(br.getFieldErrors());
		
		int cid = customerService.addCustomer(custDto);
		
		return new SuccessMessage("customer added with Customer ID " + cid);
		
	}
	
	@GetMapping("viewbyid/{custid}")
	public Customer viewCustomerById(@PathVariable("custid") Integer custId) throws CustomerNotFoundException {
		Customer customer = customerService.viewCustomerById(custId);
		return customer;
		
	}
	
	@GetMapping("viewbycontactno/{contactno}")
	public List<Customer> viewCustomer(@PathVariable("contactno") String contactNo) throws CustomerNotFoundException {
		List<Customer> lst = customerService.viewCustomer(contactNo);
		return lst;
		
	}
}
