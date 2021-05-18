package com.cg.oam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oam.dto.CartDto;
import com.cg.oam.dto.SuccessMessage;
import com.cg.oam.entities.Cart;
import com.cg.oam.exceptions.CartIdInvalidException;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.exceptions.EmptyCartException;
import com.cg.oam.exceptions.MedicineNotFoundException;
import com.cg.oam.exceptions.ValidateCustomerException;
import com.cg.oam.service.ICartService;

@RestController
public class CartRestController {

	@Autowired
	private ICartService service;

	@PostMapping("addtocart")
	public SuccessMessage addMedicineCart(@RequestBody CartDto cartdto, BindingResult br)
			throws CustomerNotFoundException, MedicineNotFoundException, ValidateCustomerException {
		System.out.println("adding items to cart");
		if (br.hasErrors())
			throw new ValidateCustomerException(br.getFieldErrors());
		Integer cartId = service.addMedicineCart(cartdto);
		return new SuccessMessage("item added to cart with cartid " + cartId);
	}

	@DeleteMapping("removeallmedicinesbycustid/{custId}")
	public SuccessMessage removeAllMedicines(@PathVariable Integer custId) throws CustomerNotFoundException {
		System.out.println("removing all cart items of customer id" + custId);
		service.removeAllMedicines(custId);
		return new SuccessMessage("Itenms deleted for customer_id" + custId);

	}

	@DeleteMapping("removeallmedicinesbycartid/{cartId}")
	public SuccessMessage removeItemsCartId(@PathVariable Integer cartId) throws CartIdInvalidException {
		System.out.println("removing all cart items of cart id" + cartId);
		service.removeItemsCartId(cartId);
		return new SuccessMessage("Item deleted for cart_id" + cartId);

	}
	
//	@PutMapping
//	public SuccessMessage qtyEdit(CartDto cartdto) throws CartIdInvalidException {
//		
//		System.out.println("editing the Quantity of cart by Cart Id");
//		
//		return null;
//	}

	@GetMapping("vieworderbycustomerid/{customerId}")
	public List<Cart> viewByCustomerId(@PathVariable Integer customerId) throws CustomerNotFoundException {
		System.out.println("viewing cart instances by customer id");
		return service.viewByCustomerId(customerId);
	}
	
	@GetMapping("viewallcartitems")
	public List<Cart> viewAllCartItems() throws EmptyCartException{
		System.out.println("viewing all the elements of the cart");
		return service.viewAllCartItems();
	}
}
