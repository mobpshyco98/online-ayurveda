package com.cg.oam.service;

import java.util.List;

import com.cg.oam.dto.CartDto;
import com.cg.oam.entities.Cart;
import com.cg.oam.exceptions.CartIdInvalidException;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.exceptions.EmptyCartException;
import com.cg.oam.exceptions.MedicineNotFoundException;

public interface ICartService {
	public Integer addMedicineCart(CartDto cartdto) throws CustomerNotFoundException, MedicineNotFoundException;

	public boolean removeAllMedicines(Integer custId) throws CustomerNotFoundException;

	public boolean removeItemsCartId(Integer cartId) throws CartIdInvalidException;

	public boolean qtyEdit(Integer cartId, Integer qty) throws CartIdInvalidException;

	public List<Cart> viewByCustomerId(Integer customerId) throws CustomerNotFoundException;

	public List<Cart> viewAllCartItems() throws EmptyCartException;
	
	public Cart getByCartId(Integer cartId) throws CartIdInvalidException;
}
