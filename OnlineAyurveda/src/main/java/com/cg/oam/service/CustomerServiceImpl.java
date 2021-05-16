package com.cg.oam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cg.oam.dao.ICustDao;
import com.cg.oam.dto.CustDto;
import com.cg.oam.entities.Customer;

@Service("myser")
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustDao custDao;

	@Override
	@Transactional
	public Integer addCustomer(CustDto custDto) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setCustomerId(custDto.getCustId());
		customer.setCustomerName(custDto.getCustName());
		customer.setContactNo(custDto.getContactNo());
		customer.setAddress(custDto.getAddress());
		customer.setLocation(custDto.getLocation());
		
		Customer persistedCust = custDao.save(customer);
		return persistedCust.getCustomerId();
		
	}


	

	
}
