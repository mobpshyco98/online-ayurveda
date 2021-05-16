package com.cg.oam.service;


import java.util.Optional;

import com.cg.oam.dto.CustomerDto;
import com.cg.oam.entities.Customer;
import com.cg.oam.exceptions.CustomerNotFoundException;

public interface ICustomerService {

	
	public Integer addCustomer(CustomerDto custDto);
	public Optional<Customer> viewCustomerById(Integer eid) throws CustomerNotFoundException;
	public Customer viewCustomerByNo(String contactNo);
	
}
