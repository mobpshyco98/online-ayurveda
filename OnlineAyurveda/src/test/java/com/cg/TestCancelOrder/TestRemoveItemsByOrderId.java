package com.cg.TestCancelOrder;

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

import com.cg.oam.dao.IOrderMedicineDao;
import com.cg.oam.entities.OrderMedicine;
import com.cg.oam.exceptions.OrderIdInvalidException;
import com.cg.oam.service.IOrderService;
import com.cg.oam.service.OrderServiceImpl;

@SpringBootTest
public class TestRemoveItemsByOrderId {
	
	@Mock
	private IOrderMedicineDao orderMedDao;
	
	@InjectMocks
	private IOrderService orderService = new OrderServiceImpl();
	
	@BeforeEach
	public void beforeEach() {
		Optional<OrderMedicine> optValid = Optional.of(new OrderMedicine());
		Optional<OrderMedicine> optInvalid = Optional.empty();
		
		when(orderMedDao.findById(100)).thenReturn(optValid);
		when(orderMedDao.findById(278)).thenReturn(optInvalid);
	}
	
	@Test
	@DisplayName(value = "Test cancel order for valid OrderId 100")
	public void testCancelOrderValid() throws OrderIdInvalidException {
		assertNotNull(orderService.removeItemsByOrderId(100));
	}
	
	@Test
	@DisplayName(value = "Test cancel order for invalid OrderId 278")
	public void testCancelOrderInvalid() throws OrderIdInvalidException {
		assertThrows(OrderIdInvalidException.class, () -> orderService.removeItemsByOrderId(278));
	}
	
}
