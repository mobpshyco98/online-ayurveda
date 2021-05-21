package com.cg.oam.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.oam.dao.ICustomerDao;
import com.cg.oam.dto.CustomerDto;
import com.cg.oam.entities.Customer;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.util.CustomerConstants;

/**
 * @author Shreyasi Karmakar
 * @Version 
 * Description - This service class contains the methods for adding a new customer, view a customer by customerId, viewing a customer by contact number and editing a customer
 */

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerDao custDao; //repository object(autowired)
	
	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	/**
	 * Method: addCustomer
	 * @Override: It is used to override the JpaRepository methods for performing CRUD operations. 
	 * @Param CustomerDto custDto
	 * @return Integer value i.e., customer ID
	 * Description: This methods returns the customer ID after adding the customer instances in the database.
	 * @CreatedAt: 
	**/
	@Override
	@Transactional
	public Integer addCustomer(CustomerDto custDto) {

		Customer customer = new Customer();
		customer.setCustomerId(custDto.getCustomerId());
		customer.setCustomerName(custDto.getCustomerName());
		customer.setContactNo(custDto.getContactNo());
		customer.setAddress(custDto.getAddress());
		customer.setLocation(custDto.getLocation());
		
		Customer persistedCust = custDao.save(customer);
		logger.info(CustomerConstants.CUSTOMER_ADDED);
		return persistedCust.getCustomerId();
		
	}

	/**
	 * Method: viewCustomerById
	 * @Override: It is used to override the JpaRepository methods for performing CRUD operations.
	 * @Param CustId Customer ID
	 * @return Customer instance
	 * @Throws throws CustomerNotFound Exception if the customer ID is not found
	 * Description: This methods returns the customer instance for a given ID and throws exception if the ID is not in the database.
	 * @CreatedAt: 
	**/
	@Override
	public Customer viewCustomerById(Integer custId) throws CustomerNotFoundException {

		Optional<Customer> customer = custDao.findById(custId);
		if(!customer.isPresent()) {
			logger.error(CustomerConstants.CUSTOMER_NOT_FOUND);
			throw new CustomerNotFoundException(CustomerConstants.CUSTOMER_NOT_FOUND);
		}
		return customer.get();
	}

	/**
	 * Method: viewCustomer
	 * @Override: It is used to override the JpaRepository methods for performing CRUD operations.
	 * @Param String contactNo
	 * @return Customer instance
	 * @Throws throws CustomerNotFound Exception if the customer contact number is not found
	 * Description: This methods returns the customer instance for a given contact number and throws exception if the number is not found.
	 * @CreatedAt: 
	**/
	@Override
	public Optional<Customer> viewCustomer(String contactNo) throws CustomerNotFoundException {
		
		Optional<Customer> optcustomer = custDao.viewCustomer(contactNo);
		if(!optcustomer.isPresent()) {
			logger.error(CustomerConstants.CUSTOMER_NOT_FOUND);
			throw new CustomerNotFoundException(CustomerConstants.CUSTOMER_NOT_FOUND);
		}
		return optcustomer;
	}

	/**
	 * Method: editCustomer
	 * @Override: It is used to override the JpaRepository methods for performing CRUD operations.
	 * @Param CustomerDto custDto
	 * @return String
	 * @Throws throws CustomerNotFound Exception if the customer ID is not found
	 * Description: This methods edits the customer instances and saves it in the database if the ID is present and throws exception if the ID is not found.
	 * @CreatedAt: 
	**/
	@Override
	public String editCustomer(CustomerDto custDto) throws CustomerNotFoundException {

		Optional<Customer> custopt = custDao.findById(custDto.getCustomerId());
		if(!custopt.isPresent()) {
			logger.error(CustomerConstants.CUSTOMER_NOT_FOUND);
			throw new CustomerNotFoundException(CustomerConstants.CUSTOMER_NOT_FOUND);
		}
		Customer customer = custopt.get();
		customer.setCustomerId(custDto.getCustomerId());
		customer.setCustomerName(custDto.getCustomerName());
		customer.setContactNo(custDto.getContactNo());
		customer.setAddress(custDto.getAddress());
		customer.setLocation(custDto.getLocation());
		custDao.save(customer);
		logger.info(CustomerConstants.CUSTOMER_EDITED);
		return CustomerConstants.CUSTOMER_EDITED;
	}
}
