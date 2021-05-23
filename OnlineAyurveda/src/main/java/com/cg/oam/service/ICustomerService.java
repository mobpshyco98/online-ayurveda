package com.cg.oam.service;

import java.util.Optional;
import com.cg.oam.dto.CustomerDto;
import com.cg.oam.entities.Customer;
import com.cg.oam.exceptions.CustomerNotFoundException;

public interface ICustomerService {

	public Integer addCustomer(CustomerDto custDto);

	public Customer viewCustomerById(Integer eid) throws CustomerNotFoundException;

	public Optional<Customer> viewCustomer(String contactNo) throws CustomerNotFoundException;

	public String editCustomer(CustomerDto custDto) throws CustomerNotFoundException;

}
