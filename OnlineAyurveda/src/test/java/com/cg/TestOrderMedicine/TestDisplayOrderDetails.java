package com.cg.TestOrderMedicine;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oam.dao.IOrderMedicineDetailDao;
import com.cg.oam.entities.OrderMedicineDetails;
import com.cg.oam.exceptions.OrderMedicineNotFoundException;
import com.cg.oam.service.IOrderedMedicineService;
import com.cg.oam.service.OrderedMedicineImpl;

@SpringBootTest
class TestDisplayOrderDetails {
	
	@Mock
	private IOrderMedicineDetailDao orderDao;
	
	@InjectMocks
	private IOrderedMedicineService service = new OrderedMedicineImpl();
	
	@BeforeEach
	private void beforeEach() {
		List<OrderMedicineDetails> lst = new ArrayList<>();
		lst.add(new OrderMedicineDetails());
		lst.add(new OrderMedicineDetails());
		List<OrderMedicineDetails> lst1 = new ArrayList<>();
		
		when(orderDao.getMedicineDetailsInOrder(1030)).thenReturn(lst);
		when(orderDao.getMedicineDetailsInOrder(4030)).thenReturn(lst1);
		
		when(orderDao.findAll()).thenReturn(lst);
	}

	@Test
	@DisplayName(value = "Test for orderId 1030")
	public void testDisplayOrderDetails1() throws OrderMedicineNotFoundException {
		assertTrue(service.displayOrderDetails(1030).size() > 0);
	}
	
	@Test
	@DisplayName(value = "Test for Customer Id 4030")
	public void testDisplayOrderDetails2() {
		assertThrows(OrderMedicineNotFoundException.class, () -> service.displayOrderDetails(4030));
	}	
}
