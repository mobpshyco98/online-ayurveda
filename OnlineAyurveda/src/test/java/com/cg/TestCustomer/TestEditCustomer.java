package com.cg.TestCustomer;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oam.dao.ICustomerDao;
import com.cg.oam.dto.CustomerDto;
import com.cg.oam.entities.Customer;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.service.CustomerServiceImpl;

@SpringBootTest
class TestEditCustomer {

	@Mock
	private ICustomerDao custDao; //creating mock instance for DAO class
	
	@InjectMocks
	private CustomerServiceImpl service = new CustomerServiceImpl(); //creating new instance for Service class and injecting the mock instance

	@BeforeEach
	public void beforeEach() {
		Optional<Customer> optcust1 = Optional.of(new Customer());
		Optional<Customer> optcust2 = Optional.of(new Customer());
		Optional<Customer> optcust3 = Optional.of(new Customer());
		Optional<Customer> optcust4 = Optional.empty();

		when(custDao.findById(1001)).thenReturn(optcust1);
		when(custDao.findById(1002)).thenReturn(optcust2);
		when(custDao.findById(1003)).thenReturn(optcust3);
		when(custDao.findById(2200)).thenReturn(optcust4);
	}
	
	@Test
	@DisplayName(value = "testing editCustomer method for id 1001")
	void edittest1() throws CustomerNotFoundException {
		CustomerDto custDto = new CustomerDto(1001, "Aman Singh", "8745986521","Kolkata", "West Bengal");
		assertNotNull(service.editCustomer(custDto));
	}
	
	@Test
	@DisplayName(value = "testing editCustomer method for id 1002")
	void edittest2() throws CustomerNotFoundException {
		CustomerDto custDto = new CustomerDto(1002, "Arjun Singh", "9748626521","Dum Dum", "West Bengal");
		assertNotNull(service.editCustomer(custDto));
	}
	
	@Test
	@DisplayName(value = "testing editCustomer method for id 1003")
	void edittest3() throws CustomerNotFoundException {
		CustomerDto custDto = new CustomerDto(1001, "Sangeeta Chowdhury", "9865132211","Pune", "Maharashtra");
		assertNotNull(service.editCustomer(custDto));
	}
	
	@Test
	@DisplayName(value = "testing editCustomer method for id 2200")
	void edittest4() throws CustomerNotFoundException {
		CustomerDto custDto = new CustomerDto(2200, "Samar Chowdhury", "9865133311","Pune", "Maharashtra");
		assertThrows(CustomerNotFoundException.class, ( ) -> service.editCustomer(custDto));
	}
}
