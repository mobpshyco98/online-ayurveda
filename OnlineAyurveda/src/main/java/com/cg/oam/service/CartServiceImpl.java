package com.cg.oam.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oam.controllers.CartRestController;
import com.cg.oam.dao.ICartDao;
import com.cg.oam.dao.ICustomerDao;
import com.cg.oam.dao.IMedicineDao;
import com.cg.oam.dto.CartDto;
import com.cg.oam.entities.Cart;
import com.cg.oam.entities.Customer;
import com.cg.oam.entities.Medicine;
import com.cg.oam.exceptions.CartIdInvalidException;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.exceptions.EmptyCartException;
import com.cg.oam.exceptions.MedicineNotFoundException;
import com.cg.oam.util.CartConstants;

/**
 * @author Sourabh Chowdhury
 * @version 
 * Description This service class contains the implementation of the
 *          cart services like adding medicines to cart,removing all medicines
 *          from the cart removing items by cart id, editing the quantity of
 *          items,viewing customer's cart items
 */

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	private ICartDao cartdao;

	@Autowired
	private ICustomerDao custdao;

	@Autowired
	private IMedicineDao medsdao;

	Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
	/**
	 * Method: addMedicine
	 * @param CartDto cartdto
	 * @return Integer i.e., the auto-generated cartId
	 * Description This method adds a cart item into the cg_cart table accepting the input in object of CartDto class 
	 * 				and returns the cartId of the item added
	 **/
	@Override
	public Integer addMedicineCart(CartDto cartdto) throws CustomerNotFoundException, MedicineNotFoundException {
		Cart cart = new Cart();
		Customer cust = null;
		cust = custdao.viewByCustomerId(cartdto.getCustId());
		Medicine meds = null;
		meds = medsdao.getMedicineByMedicineId(cartdto.getMedicineId());
		if (meds == null) {
			logger.error(CartConstants.MEDS_NOT_FOUND);
			throw new MedicineNotFoundException(CartConstants.MEDS_NOT_FOUND);
		}
		if (cust == null) {
			logger.error(CartConstants.INVALID_CUSTOMER);
			throw new CustomerNotFoundException(CartConstants.INVALID_CUSTOMER);
		}
		cart.setQty(cartdto.getQty());
		cart.setCust(cust);
		cart.setMedicine(meds);
		Cart savedCart = cartdao.save(cart);
		return savedCart.getCartId();
	}
	/**
	 * Method: removeAllMedicines
	 * @param Integer custId
	 * @return boolean; returns true if the medicines are removed successfully else throws CustomerNotFoundException
	 * Description This method removes all the medicines for a particular customer by customerId and returns true if successfully removed 
	 * 				else throws an exception if the customer id is wrong. 
	 * 
	 **/

	@Override
	public boolean removeAllMedicines(Integer custId) throws CustomerNotFoundException {
		List<Cart> lst = cartdao.viewByCustId(custId);
		if (lst.isEmpty()) {
			logger.error(CartConstants.INVALID_CUSTOMER);
			throw new CustomerNotFoundException(CartConstants.INVALID_CUSTOMER);
		}
		lst.forEach(e -> cartdao.delete(e));
		return true;
	}
	/**
	 * Method: removeItemsCartId
	 * @param Integer cartId
	 * @return Boolean returns true if removed successfully else throws CartIdInvalidException
	 * Description This method removes the items by cartId throws exception if CartId is not found in cg_cart table.
	 * 
	 **/

	@Override
	public boolean removeItemsCartId(Integer cartId) throws CartIdInvalidException {
		Optional<Cart> obj = cartdao.findById(cartId);
		if (!obj.isPresent()) {
			logger.error(CartConstants.INVALID_CART_ID);
			throw new CartIdInvalidException(CartConstants.INVALID_CART_ID);
		}
		cartdao.delete(obj.get());
		return true;
	}	
	/**
	 * Method: qtyEdit
	 * @param Integer cartId,Integer qty
	 * @return Boolean returns true the cart id quantity is  edited successfully else throws CartIdInvalidException
	 * Description This method edits the quantity for a particular cart item identified by the cart id, If invalid cart id is given for 
	 * 				editing the field then it throws exception 
	 **/
	@Override
	public boolean qtyEdit(Integer cartId, Integer qty) throws CartIdInvalidException {
		Optional<Cart> obj = cartdao.findById(cartId);
		if (!obj.isPresent()) {
			logger.error(CartConstants.INVALID_CART_ID);
			throw new CartIdInvalidException(CartConstants.INVALID_CART_ID);
		}
		Cart cart = obj.get();
		cart.setQty(qty);
		cartdao.save(cart);
		return true;
	}
	/**
	 * Method: viewByCustomerId
	 * @param Integer customerId
	 * @return List<Cart>; it returns the list of cartItems purchased by the customer
	 * Description This method gives us the list of cartItems purchased by the customer identified by CustomerId, and throws 
	 * 				an Exception if the customer has not bought anything.
	 **/
	@Override
	public List<Cart> viewByCustomerId(Integer customerId) throws CustomerNotFoundException {
		List<Cart> lst = cartdao.viewByCustId(customerId);
		if (lst.isEmpty()) {
			logger.error(CartConstants.INVALID_CUSTOMER);
			throw new CustomerNotFoundException(CartConstants.INVALID_CUSTOMER);
		}
		return lst;
	}
	/**
	 * Method: viewAllCartItems
	 * @param  
	 * @return List<Cart>; it returns ALL cartItems from all customers
	 * Description This method gives us the list of cartItems all the items added to cart by all customers
	 **/
	@Override
	public List<Cart> viewAllCartItems() throws EmptyCartException {
		List<Cart> lst = cartdao.findAll();
		if (lst.isEmpty()) {
			logger.error(CartConstants.EMPTY_CART);
			throw new EmptyCartException(CartConstants.EMPTY_CART);
		}
		return lst;
	}

}
