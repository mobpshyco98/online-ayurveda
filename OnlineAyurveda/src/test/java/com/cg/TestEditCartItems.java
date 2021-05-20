package com.cg;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oam.dao.ICartDao;
import com.cg.oam.entities.Cart;
import com.cg.oam.exceptions.CartIdInvalidException;
import com.cg.oam.service.CartServiceImpl;
import com.cg.oam.service.ICartService;

@SpringBootTest
public class TestEditCartItems {

	@Mock
	private ICartDao cartdao;

	@InjectMocks
	private ICartService service = new CartServiceImpl();

	@BeforeEach
	public void beforeEach() {
		Optional<Cart> optcart1 = Optional.of(new Cart());
		Optional<Cart> optcart2 = Optional.empty();

		when(cartdao.findById(1020)).thenReturn(optcart1);
		when(cartdao.findById(6873)).thenReturn(optcart2);
	}

	@Test
	@DisplayName(value = "testing edit method for id 1020")
	public void edittest1() throws CartIdInvalidException {
		assertNotNull(service.qtyEdit(1020, 51));
	}

	@Test
	@DisplayName(value = "testing edit method for id 6873")
	public void edittest2() {
		assertThrows(CartIdInvalidException.class, () -> service.qtyEdit(6873, 75));
	}
}
