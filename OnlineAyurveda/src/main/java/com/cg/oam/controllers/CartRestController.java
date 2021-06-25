package com.cg.oam.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.cg.oam.util.CartConstants;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class CartRestController {

	@Autowired
	private ICartService service;

	Logger logger = LoggerFactory.getLogger(CartRestController.class);
	/**
	 * Method: addMedicineCart
	 * @Param CustomerDto custDto, BindingResult br
	 * @return SuccessMessage along with cart ID
	 * @postMapping: ("addtocart")It is used to handle the HTTP Post requests matched with given URI Expression
	 * @RequestBody: (CartDto cartdto)Injects the request body that contains JSON to the method argument using HttpMessageConverters
	 * @Valid: It validates the bean and injects the errors in Spring BindingResult instance.
	 * @throws throws Validate Exception if the values entered in JSON body doesn't match with the validations given in the Dto class,
	 * 		   throws CustomerNotFoundException if valid customerId is not provided
	 * 		   throws MedicineNotFoundException if valid MedicineId is not provided	
	 * Description: This methods returns a SuccessMessage along with the cart ID after adding the cart instances in the database.
	 * @CreatedAt: 
	**/
	@PostMapping("addtocart") // done
	public SuccessMessage addMedicineCart(@Valid @RequestBody CartDto cartdto, BindingResult br)
			throws CustomerNotFoundException, MedicineNotFoundException, ValidateException {
		logger.info(CartConstants.ADDED_TO_CART);
		if (br.hasErrors()) {
			logger.error(CartConstants.VALIDATE_EXP);
			throw new ValidateException(br.getFieldErrors());
		}
		Integer cartId = service.addMedicineCart(cartdto);
		return new SuccessMessage("item added to cart with cartid " + cartId);
	}
	/**
	 * Method: removeAllMedicines
	 * @Param Interger custId
	 * @return SuccessMessage along with cart ID
	 * @DeleteMapping: ("removeallmedicinesbycustid/{custId}") It helps to map HTTP DELETE requests onto the handler method.
	 * @PathVariable: (Intger custId) This annotation is used to handle template variables in the request URI mapping, and use them as method parameters.
	 * @throws throws CustomerNotFoundException if valid customerId is present	
	 * Description: This methods returns a SuccessMessage customer id for which cart items are deleted.
	 * @CreatedAt: 
	**/
	
	@DeleteMapping("removeallmedicinesbycustid/{custId}") // done
	public SuccessMessage removeAllMedicines(@PathVariable Integer custId) throws CustomerNotFoundException {
		logger.info(CartConstants.REMOVE_BY_CUST_ID);
		service.removeAllMedicines(custId);
		return new SuccessMessage(CartConstants.DELETE_SUCCESS_CUST_ID + custId);

	}
	/**
	 * Method: removeallmedicinesbycartid
	 * @Param  Integer cartId
	 * @return SuccessMessage along with cart ID
	 * @DeleteMapping: ("removeallmedicinesbycartid/{cartId}") It helps to map HTTP DELETE requests onto the handler method.
	 * @PathVariable: (Integer cartId) This annotation is used to handle template variables in the request URI mapping, and use them as method parameters.
	 * @throws throws CartIdInvalidException if valid cartId is not provided	
	 * Description: This methods returns a SuccessMessage along with cart id which is deleted.
	 * @CreatedAt: 
	**/
	
	@DeleteMapping("removemedicinesbycartid/{cartId}") // done
	public SuccessMessage removeItemsCartId(@PathVariable Integer cartId) throws CartIdInvalidException {
		service.removeItemsCartId(cartId);
		logger.info(CartConstants.REMOVE_BY_CART_ID);
		return new SuccessMessage(CartConstants.DELETE_SUCCESS_CART_ID + cartId);

	}
	/**
	 * Method: qtyedit
	 * @putMapping:("qtyedit/{cartId}/{qty}") It is used to handle the HTTP PUT requests matched with given URI Expression
	 * @Param Integer cartId, Integer qty
	 * @PathVariable (Integer cartId,Integer qty) This annotation is used to handle template variables in the request URI mapping, and use them as method parameters.
	 * @return SuccessMessage and the cartId of the item edited.
	 * @throws throws CartIdInvalidException if the cartid is not present in the cart table
	 * Description: This methods returns a SuccessMessage after editing the cartitem's  quantity.
	 * @CreatedAt: 
	**/
	
	@PutMapping("qtyedit/{cartId}/{qty}") // done
	public SuccessMessage qtyEdit(@PathVariable Integer cartId,@NotNull @PathVariable Integer qty)
			throws CartIdInvalidException {
		service.qtyEdit(cartId, qty);
		logger.info(CartConstants.EDIT_BY_CART_ID);
		return new SuccessMessage(CartConstants.ITEM_EDIT_SUCCESS + cartId);
	}

	/**
	 * Method: viewAllCartItems
	 * @GetMapping:("viewallcartitems") It is used to handle the HTTP get requests matched with given URI Expression
	 * @return List of all the cart items
	 * @throws throws EmptyCartException if the cart table is found to be empty
	 * Description: this method returns all the cart items.
	 * @CreatedAt: 
	**/
	
	@GetMapping("viewallcartitems") //
	public List<Cart> viewAllCartItems() throws EmptyCartException {
		logger.info(CartConstants.CART_VIEW_ALL);
		return service.viewAllCartItems();
	}
	/**
	 * Method: viewByCustomerId
	 * @GetMapping:It is used to handle the HTTP get requests matched with given URI Expression
	 * @Param String contactNo
	 * @PathVariable: extract values from the URI path to method argument
	 * @return List of customer instance present in the cart table and Http response status as OK.
	 * @throws throws CustomerNotFound exception if the contact number is not found
	 * Description: This methods returns customer instances.
	 * @CreatedAt: 
	**/
	
	@GetMapping("vieworderbycustomerid/{customerId}") // done
	public List<Cart> viewByCustomerId(@PathVariable Integer customerId)
			throws CustomerNotFoundException {
		logger.info(CartConstants.VIEW_ORD_BY_CUST_ID);
		return service.viewByCustomerId(customerId);
	}
	
	@GetMapping("getByCartId/{cartId}")
	public Cart getByCartId(@PathVariable Integer cartId) throws CartIdInvalidException {
		return service.getByCartId(cartId);
	}
}
