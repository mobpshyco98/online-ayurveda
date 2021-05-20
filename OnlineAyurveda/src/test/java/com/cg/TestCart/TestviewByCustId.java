package com.cg.TestCart;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.cg.oam.dao.ICartDao;
import com.cg.oam.entities.Cart;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.exceptions.EmptyCartException;
import com.cg.oam.service.CartServiceImpl;
import com.cg.oam.service.ICartService;

@SpringBootTest
public class TestviewByCustId {

	@Mock
	private ICartDao cartdao;

	@InjectMocks
	private ICartService service = new CartServiceImpl();

	@BeforeEach
	void beforeEach() {
		List<Cart> lst = new ArrayList<>();
		lst.add(new Cart());
		lst.add(new Cart());
		List<Cart> lst1 = new ArrayList<>();

		when(cartdao.viewByCustId(1001)).thenReturn(lst);
		when(cartdao.viewByCustId(4550)).thenReturn(lst1);

		when(cartdao.findAll()).thenReturn(lst);
	}

	@Test
	@DisplayName(value = "Test for customerID 1001")
	public void testviewbycustomerid1() throws CustomerNotFoundException {
		assertTrue(service.viewByCustomerId(1001).size() > 0);
	}

	@Test
	@DisplayName(value = "Test for customerID 4550")
	public void testviewbycustomerid2() {
		assertThrows(CustomerNotFoundException.class, () -> service.viewByCustomerId(4550));
	}

	@Test
	@DisplayName(value = "Test for diplaying all elements")
	public void testviewall1() throws EmptyCartException {
		assertTrue(service.viewAllCartItems().size() > 0);
	}
}
