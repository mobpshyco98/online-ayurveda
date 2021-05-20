package com.cg;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oam.dao.ICartDao;
import com.cg.oam.entities.Cart;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.service.CartServiceImpl;
import com.cg.oam.service.ICartService;

@SpringBootTest
public class TestRemoveAllMedicines {

	@Mock
	private ICartDao cartdao;

	@InjectMocks
	private ICartService service = new CartServiceImpl();

	@BeforeEach
	public void beforeEach() {
		List<Cart> lst = new ArrayList<>();
		lst.add(new Cart());
		lst.add(new Cart());

		List<Cart> lst1 = new ArrayList<>();

		when(cartdao.viewByCustId(1001)).thenReturn(lst);
		when(cartdao.viewByCustId(2323)).thenReturn(lst1);
	}

	@Test
	@DisplayName(value = "testing for valid customer id 1001")
	public void removetest1() throws CustomerNotFoundException {
		assertTrue(service.removeAllMedicines(1001));
	}

	@Test
	@DisplayName(value = "testing for invalid customer id 2323")
	public void removetest2() {
		assertThrows(CustomerNotFoundException.class, () -> service.removeAllMedicines(2323));
	}

}
