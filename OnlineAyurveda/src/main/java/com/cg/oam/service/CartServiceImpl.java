package com.cg.oam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service

public class CartServiceImpl implements ICartService {

	@Autowired
	private ICartDao cartdao;

	@Autowired
	private ICustomerDao custdao;

	@Autowired
	private IMedicineDao medsdao;

	@Override
	public Integer addMedicineCart(CartDto cartdto) throws CustomerNotFoundException, MedicineNotFoundException {
		Cart cart = new Cart();
		Customer cust = null;
		cust = custdao.viewByCustomerId(cartdto.getCustId());
		Medicine meds = null;
		meds = medsdao.findByMedicineId(cartdto.getMedicineId());
		if (meds == null)
			throw new MedicineNotFoundException(CartConstants.MEDS_NOT_FOUND);
		if (cust == null)
			throw new CustomerNotFoundException(CartConstants.INVALID_CUSTOMER);
		cart.setQty(cartdto.getQty());
		cart.setCust(cust);
		cart.setMedicine(meds);
		Cart savedCart = cartdao.save(cart);
		return savedCart.getCartId();
	}

	@Override
	public boolean removeAllMedicines(Integer custId) throws CustomerNotFoundException {
		List<Cart> lst = cartdao.viewByCustId(custId);
		if (lst.isEmpty())
			throw new CustomerNotFoundException(CartConstants.INVALID_CUSTOMER);
		lst.forEach(e -> cartdao.delete(e));
		return true;
	}

	@Override
	public boolean removeItemsCartId(Integer cartId) throws CartIdInvalidException {
		Optional<Cart> obj = cartdao.findById(cartId);
		if(!obj.isPresent())
			throw new CartIdInvalidException("id is invalid given");
		cartdao.delete(obj.get());
		return true;
	}

	@Override
	public boolean qtyEdit(Integer cartId, Integer qty) throws CartIdInvalidException {
		Optional<Cart> obj = cartdao.findById(cartId);
		if(!obj.isPresent())
			throw new CartIdInvalidException("id is invalid given");
		Cart cart = obj.get();
		cart.setQty(qty);
		cartdao.save(cart);
		return true;
	}

	@Override
	public List<Cart> viewByCustomerId(Integer customerId) throws CustomerNotFoundException {
		List<Cart> lst = cartdao.viewByCustId(customerId);
		if (lst.isEmpty())
			throw new CustomerNotFoundException(CartConstants.INVALID_CUSTOMER);
		return lst;
	}

	@Override
	public List<Cart> viewAllCartItems() throws EmptyCartException {
		List<Cart> lst = cartdao.findAll();
		if (lst.isEmpty())
			throw new EmptyCartException(CartConstants.EMPTY_CART);
		return lst;
	}

}
