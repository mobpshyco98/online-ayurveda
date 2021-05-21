package com.cg.TestCustomer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.cg.oam.dao.ICustomerDao;
import com.cg.oam.entities.Customer;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.service.CustomerServiceImpl;

@SpringBootTest
class TestViewById {

	@Mock
	private ICustomerDao custDao; //creating mock instance for DAO class
	
	@InjectMocks
	private CustomerServiceImpl service = new CustomerServiceImpl(); //creating new instance for Service class and injecting the mock instance
	
	@BeforeEach
	public void beforeEach() {
		//stub code for mock instance
		Optional<Customer> optcust1 = Optional.of(new Customer());
		Optional<Customer> optcust2 = Optional.of(new Customer());
		Optional<Customer> optcust3 = Optional.empty();
		//return the instance for the given id
		when(custDao.findById(1001)).thenReturn(optcust1);
		when(custDao.findById(1002)).thenReturn(optcust2);
		when(custDao.findById(1005)).thenReturn(optcust3);
		
	}
	
	@Test
	@DisplayName(value="testViewById for 1001")
	void testViewById1() throws CustomerNotFoundException {
		assertNotNull(service.viewCustomerById(1001));
	}
	
	@Test
	@DisplayName(value="testViewById for 1002")
	void testViewById2() throws CustomerNotFoundException {
		assertNotNull(service.viewCustomerById(1002));
	}
	
	@Test
	@DisplayName(value="testViewById for 1005")
	void testViewById3() throws CustomerNotFoundException {
		assertThrows(CustomerNotFoundException.class, (  )-> service.viewCustomerById(1005));
	}
}
