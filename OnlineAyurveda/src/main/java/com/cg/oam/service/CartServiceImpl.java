package com.cg.oam.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
		cust = custdao.findByCustomerId(cartdto.getCustId());
		Medicine meds = null;
		meds = medsdao.findByMedicineId(cartdto.getMedicineId());
		if (meds == null)
			throw new MedicineNotFoundException("Entered Medicine is not found");
		if (cust == null)
			throw new CustomerNotFoundException("Invalid Customer");
		cart.setQty(cartdto.getQty());
		cart.setCust(cust);
		cart.setMedicine(meds);
		Cart savedCart = cartdao.save(cart);
		return savedCart.getCartId();
	}

	@Override
	public boolean removeAllMedicines(CartDto cartdto) throws CustomerNotFoundException {
		List<Cart> lst = cartdao.viewByCustId(cartdto.getCustId());
		if (!lst.isEmpty())
			throw new CustomerNotFoundException("customer has no cart Items");
		lst.forEach(e -> cartdao.delete(e));
		return true;
	}

	@Override
	public boolean removeItemsCartId(CartDto cartdto) throws CartIdInvalidException {
		Optional<Cart> obj = cartdao.findById(cartdto.getCartId());
		if (obj==null)
			throw new CartIdInvalidException("invalid cart id inserted");
		cartdao.delete(obj.get());
		return true;
	}

	@Override
	public boolean qtyEdit(CartDto cartdto) throws CartIdInvalidException {
		Optional<Cart> obj = cartdao.findById(cartdto.getCartId());
		if (obj==null)
			throw new CartIdInvalidException("invalid cart id inserted");
		obj.get().setQty(cartdto.getQty());
		return true;
	}

	@Override
	public List<Cart> viewByCustomerId(CartDto cartdto) throws CustomerNotFoundException {
		List<Cart> lst = cartdao.viewByCustId(cartdto.getCustId());
		if (!lst.isEmpty())
			throw new CustomerNotFoundException("No cart items found for customer");
		return lst;
	}

	@Override
	public List<Cart> viewAllCartItems() throws EmptyCartException {
		List<Cart> lst = cartdao.findAll();
		if (!lst.isEmpty())
			throw new EmptyCartException();
		return lst;
	}

}
