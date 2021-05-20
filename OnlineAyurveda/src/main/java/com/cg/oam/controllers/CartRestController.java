package com.cg.oam.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oam.dto.CartDto;
import com.cg.oam.dto.SuccessMessage;
import com.cg.oam.entities.Cart;
import com.cg.oam.exceptions.CartIdInvalidException;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.exceptions.EmptyCartException;
import com.cg.oam.exceptions.MedicineNotFoundException;
import com.cg.oam.exceptions.ValidateException;
import com.cg.oam.service.ICartService;

@RestController
public class CartRestController {

	@Autowired
	private ICartService service;

	Logger logger = LoggerFactory.getLogger(CartRestController.class);

	@PostMapping("addtocart") // done
	public SuccessMessage addMedicineCart(@Valid @RequestBody CartDto cartdto, BindingResult br)
			throws CustomerNotFoundException, MedicineNotFoundException, ValidateException {
		System.out.println("adding items to cart");

		if (br.hasErrors())
			throw new ValidateException(br.getFieldErrors());
		Integer cartId = service.addMedicineCart(cartdto);
		return new SuccessMessage("item added to cart with cartid " + cartId);
	}

	@DeleteMapping("removeallmedicinesbycustid/{custId}") // done
	public SuccessMessage removeAllMedicines(@PathVariable Integer custId) throws CustomerNotFoundException {
		System.out.println("removing all cart items of customer id  " + custId);
		service.removeAllMedicines(custId);
		return new SuccessMessage("Itenms deleted for customer_id  " + custId);

	}

	@DeleteMapping("removeallmedicinesbycartid/{cartId}") // done
	public SuccessMessage removeItemsCartId(@PathVariable Integer cartId) throws CartIdInvalidException {
		System.out.println("removing all cart items of cart id  " + cartId);
		service.removeItemsCartId(cartId);
		return new SuccessMessage("Item deleted for cart_id  " + cartId);

	}

	@PutMapping("qtyedit/{cartId}/{qty}") // done
	public SuccessMessage qtyEdit(@PathVariable Integer cartId, @PathVariable Integer qty)
			throws CartIdInvalidException {
		System.out.println("editing the Quantity of cart_id" + cartId);
		service.qtyEdit(cartId, qty);

		return new SuccessMessage("Item edited Sucessfully for cartId " + cartId);
	}

	@GetMapping("vieworderbycustomerid/{customerId}") // done
	public List<Cart> viewByCustomerId(@PathVariable Integer customerId) throws CustomerNotFoundException {
		System.out.println("viewing cart instances by customer id ");
		return service.viewByCustomerId(customerId);
	}

	@GetMapping("viewallcartitems") //
	public List<Cart> viewAllCartItems() throws EmptyCartException {
		System.out.println("viewing all the elements of the cart");
		return service.viewAllCartItems();
	}
}
