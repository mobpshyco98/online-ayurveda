package com.cg.oam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.oam.dao.ICustomerDao;
import com.cg.oam.dto.CustomerDto;
import com.cg.oam.entities.Customer;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.exceptions.ValidateCustomerException;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerDao custDao;

	@Override
	@Transactional
	public Integer addCustomer(CustomerDto custDto) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setCustomerId(custDto.getCustomerId());
		customer.setCustomerName(custDto.getCustomerName());
		customer.setContactNo(custDto.getContactNo());
		customer.setAddress(custDto.getAddress());
		customer.setLocation(custDto.getLocation());
		
		Customer persistedCust = custDao.save(customer);
		return persistedCust.getCustomerId();
		
	}

	@Override
	public Customer viewCustomerById(Integer custId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> customer = custDao.findById(custId);
		if(!customer.isPresent())
			throw new CustomerNotFoundException("Customer not found");
		
		return customer.get();
	}

	@Override
	public List<Customer> viewCustomer(String contactNo) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		List<Customer> lst = custDao.viewCustomer(contactNo);
		if(lst.isEmpty())
			throw new CustomerNotFoundException();
		return lst;
	}

	@Override
	public String editCustomer(CustomerDto custDto) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> custopt = custDao.findById(custDto.getCustomerId());
		if(!custopt.isPresent())
			throw new CustomerNotFoundException("No customer found");
		Customer customer = custopt.get();
		customer.setCustomerId(custDto.getCustomerId());
		customer.setCustomerName(custDto.getCustomerName());
		customer.setContactNo(custDto.getContactNo());
		customer.setAddress(custDto.getAddress());
		customer.setLocation(custDto.getLocation());
		Customer persistedCustomer = custDao.save(customer);
		return "Edited successfully";
	}

	


	

	
}
