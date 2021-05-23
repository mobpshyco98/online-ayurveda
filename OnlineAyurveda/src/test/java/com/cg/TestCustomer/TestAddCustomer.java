package com.cg.TestCustomer;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.oam.dao.ICustomerDao;
import com.cg.oam.dto.CustomerDto;
import com.cg.oam.entities.Customer;
import com.cg.oam.service.CustomerServiceImpl;

@SpringBootTest
class TestAddCustomer {

	@Mock
	private ICustomerDao custDao; // creating mock instance for DAO class

	@InjectMocks
	private CustomerServiceImpl service = new CustomerServiceImpl(); // creating new instance for Service class and
																		// injecting the mock instance

	@BeforeEach
	public void beforeEach() {

		Customer cust = new Customer();
		cust.setCustomerId(1111);
		when(custDao.save(any(Customer.class))).thenReturn(cust);
	}

	@Test
	@DisplayName(value = "Testing customer for 1111")
	void testAddCustomer1() {
		CustomerDto custDto = new CustomerDto();
		custDto.setCustomerId(1111);
		assertTrue(service.addCustomer(custDto) == 1111);
	}
}
