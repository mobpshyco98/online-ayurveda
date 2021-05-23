package com.cg.TestOrderMedicine;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oam.dao.ICartDao;
import com.cg.oam.dao.ICustomerDao;
import com.cg.oam.dao.IMedicineSpecificationDao;
import com.cg.oam.dao.IOrderMedicineDao;
import com.cg.oam.dao.IOrderMedicineDetailDao;
import com.cg.oam.dto.OrderMedicineDto;
import com.cg.oam.entities.Cart;
import com.cg.oam.entities.Customer;
import com.cg.oam.entities.OrderMedicine;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.exceptions.EmptyCartException;
import com.cg.oam.service.IOrderedMedicineService;
import com.cg.oam.service.OrderedMedicineImpl;


@SpringBootTest
class TestCreateOrder {
	
	@Mock
	private ICustomerDao customerDao;
	
	@Mock
	private IOrderMedicineDao orderMedicineDao;
	
	@Mock
	private IOrderMedicineDetailDao orderMedicineDetailDao;
	
	@Mock
	private ICartDao cartDao;
	
	@Mock
	private IMedicineSpecificationDao medicineSpecDao;
	
	@InjectMocks
	private IOrderedMedicineService orderMedicineService = new OrderedMedicineImpl();
	
	@BeforeEach
	public void beforeEach() {
		
		Optional<Customer> customer1 = Optional.of(new Customer());
		Optional<Customer> customer2 = Optional.empty();
		
		
		
		//Optional<Customer> customer3 = Optional.of(new Customer(4320, "Aatav", "8345988841", "xyz", "kolkata"));
		
		when(customerDao.viewByCustomerId1(1001)).thenReturn(customer1);
		when(customerDao.viewByCustomerId1((1009))).thenReturn(customer2);
		//when(customerDao.viewByCustomerId1(customer1.get().getCustomerId())).thenReturn(customer3);
		
		List<Cart> cartLst = new ArrayList<>();
		List<Cart> cartLst1 = new ArrayList<>();
		
		cartLst.add(new Cart());
		cartLst.add(new Cart());
		
		
		when(cartDao.viewByCustId(1001)).thenReturn(cartLst);
		when(cartDao.viewByCustId(1009)).thenReturn(cartLst1);
		
		OrderMedicine orderMedicine = new OrderMedicine();
		orderMedicine.setOrderId(2001);
		
		when(orderMedicineDao.save(any(OrderMedicine.class))).thenReturn(orderMedicine);
	}

	@Test
	@DisplayName(value = "test of Create Order positive")
	public void testCreateOrder1() throws CustomerNotFoundException, EmptyCartException {
		OrderMedicineDto orderDto = new OrderMedicineDto(LocalDate.of(2021, 8, 11), "Confirmed", 220.0, 1001);
		assertThrows(EmptyCartException.class, () -> orderMedicineService.createOrder(orderDto));
	}
	
	@Test
	@DisplayName(value = "test of Create Order for customer not found")
	public void testCreateOrder2() {
		OrderMedicineDto orderDto = new OrderMedicineDto(LocalDate.of(2021, 8, 11), "Confirmed", 220.0, 1002);
		assertThrows(CustomerNotFoundException.class, () -> orderMedicineService.createOrder(orderDto));
	}
	
	@Test
	@DisplayName(value = "test of Create Order for cart is empty")
	public void testCreateOrder3() {
		OrderMedicineDto orderDto = new OrderMedicineDto(LocalDate.of(2021, 8, 11), "Confirmed", 220.0, 1001);
		assertThrows(EmptyCartException.class, () -> orderMedicineService.createOrder(orderDto));
	}
}
