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

import com.cg.oam.dao.IOrderMedicineDao;
import com.cg.oam.entities.OrderMedicine;
import com.cg.oam.exceptions.OrderMedicineNotFoundException;
import com.cg.oam.service.IOrderedMedicineService;
import com.cg.oam.service.OrderedMedicineImpl;

@SpringBootTest
class TestViewByCustomerId {
	
	@Mock
	private IOrderMedicineDao orderDao;
	
	@InjectMocks
	private IOrderedMedicineService service = new OrderedMedicineImpl();
	
	@BeforeEach
	private void beforeEach() {
		List<OrderMedicine> lst = new ArrayList<>();
		lst.add(new OrderMedicine());
		lst.add(new OrderMedicine());
		List<OrderMedicine> lst1 = new ArrayList<>();
		
		when(orderDao.viewOrderByCustId(1040)).thenReturn(lst);
		when(orderDao.viewOrderByCustId(2010)).thenReturn(lst1);
		
		when(orderDao.findAll()).thenReturn(lst);
	}

	@Test
	@DisplayName(value = "Test for customerId 1040")
	public void testViewOrderByCustomerId1() throws OrderMedicineNotFoundException {
		assertTrue(service.viewOrderByCustomerId(1040).size() > 0);
	}
	
	@Test
	@DisplayName(value = "Test for Customer Id 2010")
	public void testViewOrderByCustomerId2() {
		assertThrows(OrderMedicineNotFoundException.class, () -> service.viewOrderByCustomerId(2010));
	}	
}
