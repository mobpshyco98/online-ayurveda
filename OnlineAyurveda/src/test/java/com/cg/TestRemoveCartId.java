package com.cg;

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

import com.cg.oam.dao.ICartDao;
import com.cg.oam.entities.Cart;
import com.cg.oam.exceptions.CartIdInvalidException;
import com.cg.oam.service.CartServiceImpl;
import com.cg.oam.service.ICartService;

@SpringBootTest
public class TestRemoveCartId {

	@Mock
	private ICartDao cartdao;

	@InjectMocks
	private ICartService service = new CartServiceImpl();

	@BeforeEach
	public void beforeEach() {
		Optional<Cart> opt1 = Optional.of(new Cart());
		Optional<Cart> opt2 = Optional.empty();

		when(cartdao.findById(2001)).thenReturn(opt1);
		when(cartdao.findById(2456)).thenReturn(opt2);

	}

	@Test
	@DisplayName(value = "removing cart item for id 2001")
	public void test1() throws CartIdInvalidException {
		assertNotNull(service.removeItemsCartId(2001));
	}

	@Test
	@DisplayName(value = "removing cart item for id 2456")
	public void test2() {
		assertThrows(CartIdInvalidException.class, () -> service.removeItemsCartId(2456));
	}
}