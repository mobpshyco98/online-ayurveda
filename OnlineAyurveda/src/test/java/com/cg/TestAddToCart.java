package com.cg;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oam.dao.ICartDao;
import com.cg.oam.dao.ICustomerDao;
import com.cg.oam.dao.IMedicineDao;
import com.cg.oam.dto.CartDto;
import com.cg.oam.entities.Cart;
import com.cg.oam.entities.Customer;
import com.cg.oam.entities.Medicine;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.exceptions.MedicineNotFoundException;
import com.cg.oam.service.CartServiceImpl;
import com.cg.oam.service.ICartService;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestAddToCart {

	@Mock
	private ICartDao cartdao;

	@Mock
	private ICustomerDao custdao;

	@Mock
	private IMedicineDao medsdao;

	@InjectMocks
	ICartService cartService = new CartServiceImpl();

	@BeforeEach
	public void beforeEach() {
		when(custdao.viewByCustomerId(1001)).thenReturn(new Customer());
		when(custdao.viewByCustomerId(1478)).thenReturn(null);

		when(medsdao.getMedicineByMedicineId(2001)).thenReturn(new Medicine());
		when(medsdao.getMedicineByMedicineId(3214)).thenReturn(null);

		Cart savedCart = new Cart();
		savedCart.setCartId(1012);
		when(cartdao.save(any(Cart.class))).thenReturn(savedCart);
	}

	@Test
	@DisplayName(value = "adding medine to cart test for valid customerId and MedicineId")
	public void testaddemployee() throws CustomerNotFoundException, MedicineNotFoundException {
		CartDto cartdto = new CartDto(50, 1001, 2001);
		assertNotNull(cartService.addMedicineCart(cartdto));
	}

	@Test
	@DisplayName(value = "medine to cart test for invalid customerId and valid MedicineId")
	public void testaddemployee1() {
		CartDto cartdto = new CartDto(50, 1478, 2001);
		assertThrows(CustomerNotFoundException.class, () -> cartService.addMedicineCart(cartdto));
	}

	@Test
	@DisplayName(value = "medine to cart test for valid customerId and invalid MedicineId")
	public void testaddemployee2() {
		CartDto cartdto = new CartDto(50, 1001, 3214);
		assertThrows(MedicineNotFoundException.class, () -> cartService.addMedicineCart(cartdto));
	}
}
