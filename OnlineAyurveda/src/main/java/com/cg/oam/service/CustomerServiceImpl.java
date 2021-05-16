package com.cg.oam.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.oam.dao.ICustomerDao;
import com.cg.oam.dto.CustomerDto;
import com.cg.oam.entities.Customer;
import com.cg.oam.exceptions.CustomerNotFoundException;

@Service("myser")
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
	public Optional<Customer> viewCustomerById(Integer custId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		if(!custDao.existsById(custId))
			throw new CustomerNotFoundException("Customer not found");
		
		return custDao.findById(custId);
	}

	@Override
	public Customer viewCustomerByNo(String contactNo) {
		// TODO Auto-generated method stub
		
		return null;
	}


	

	
}
