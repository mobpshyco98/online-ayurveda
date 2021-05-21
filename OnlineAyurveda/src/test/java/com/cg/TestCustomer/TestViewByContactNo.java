package com.cg.TestCustomer;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import com.cg.oam.dao.ICustomerDao;
import com.cg.oam.entities.Customer;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.service.CustomerServiceImpl;

@SpringBootTest
class TestViewByContactNo {

	@Mock
	private ICustomerDao custDao; //Creating mock instance for ICustomerDao class
	
	@InjectMocks
	private CustomerServiceImpl service = new CustomerServiceImpl(); //Creating new instance for CustomerServiceImpl class and injecting the mock instance
	
	@BeforeEach
	public void beforeEach() {
		Optional<Customer> optcust1 = Optional.of(new Customer());
		Optional<Customer> optcust2 = Optional.of(new Customer());
		Optional<Customer> optcust3 = Optional.empty();
		when(custDao.viewCustomer("7896541236")).thenReturn(optcust1);
		when(custDao.viewCustomer("8985461236")).thenReturn(optcust2);
		when(custDao.viewCustomer("9999999999")).thenReturn(optcust3);
	}
	
	@Test
	@DisplayName(value = "testViewByContactNo for 7896541236")
	void testViewByContactNo1() throws CustomerNotFoundException {
		assertNotNull(service.viewCustomer("7896541236"));
	}
	
	@Test
	@DisplayName(value = "testViewByContactNo for 8985461236")
	void testViewByContactNo2() throws CustomerNotFoundException {
		assertNotNull(service.viewCustomer("8985461236"));
		
	}
	
	@Test
	@DisplayName(value = "testViewByContactNo for 9999999999")
	void testViewByContactNo3() {
		assertThrows(CustomerNotFoundException.class, ( ) -> service.viewCustomer("9999999999"));
	}
}
