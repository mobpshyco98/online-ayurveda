package com.cg.oam.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.oam.dao.ICartDao;
import com.cg.oam.dao.ICustomerDao;
import com.cg.oam.dao.IMedicineDao;
import com.cg.oam.dao.IOrderMedicineDao;
import com.cg.oam.dao.IOrderMedicineDetailDao;
import com.cg.oam.dto.OrderMedicineDto;
import com.cg.oam.entities.Cart;
import com.cg.oam.entities.Customer;
import com.cg.oam.entities.Medicine;
import com.cg.oam.entities.OrderMedicine;
import com.cg.oam.entities.OrderMedicineDetails;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.exceptions.EmptyCartException;
import com.cg.oam.exceptions.OrderMedicineNotFoundException;
import com.cg.oam.util.OrderConstants;

@Service
@Transactional
public class OrderedMedicineImpl implements IOrderedMedicineService{
	@Autowired
	private IOrderMedicineDao orderMedicineDao;
	@Autowired
	private ICustomerDao customerDao;
	@Autowired
	private IOrderMedicineDetailDao orderMedcineDetailDao;
	@Autowired
	private IMedicineDao medicineDao;
	@Autowired
	private ICartDao cartDao;
	
	// Create Order
	@Override
	public Integer createOrder(OrderMedicineDto medicineDto) throws CustomerNotFoundException, EmptyCartException {
		//updating the table cg_order_medicine
		OrderMedicine orderMedicine = new OrderMedicine();
		
		Optional<Customer> optCust = customerDao.viewByCustomerId1(medicineDto.getCustomerId());
		
		if(!optCust.isPresent())
			throw new CustomerNotFoundException(OrderConstants.CUSTOMER_NOT_FOUND);
		Customer customer = optCust.get();
		List<Cart> lstCart = cartDao.viewByCustId(customer.getCustomerId());
		if(lstCart.isEmpty())
			throw new EmptyCartException(OrderConstants.BASKET_EMPTY);
		
		orderMedicine.setOrderDate(LocalDate.now());
		orderMedicine.setCustomer_order(customer);
		orderMedicine.setOrderStatus(OrderConstants.ORDER_CONFIRMED);
		orderMedicine.setTotalCost(findTotalCost(lstCart));
		OrderMedicine savedOrder = orderMedicineDao.save(orderMedicine);
		
		for(Cart cart : lstCart) {
			Medicine medicine = cart.getMedicine();
			OrderMedicineDetails orderMediDetails = new OrderMedicineDetails();
			
			orderMediDetails.setMedicine(medicine);
			orderMediDetails.setMediOrder(orderMedicine);
			orderMedcineDetailDao.save(orderMediDetails);
			medicine.setStock(medicine.getStock()-OrderConstants.DECREMENT_BY_ONE);
			medicineDao.save(medicine);
			cartDao.delete(cart);
		}
		
		return savedOrder.getOrderId();
	}
	public double findTotalCost(List<Cart> lstCart) {
		double totalCost=0.0;
		for(Cart cart : lstCart) {
			totalCost = totalCost + cart.getMedicine().getMedicineCost();
		}
		return totalCost;
	}
	
	
	//View Order by User Id
	@Override
	public List<OrderMedicine> viewOrderByCustomerId(Integer custId) throws OrderMedicineNotFoundException {
		/**Optional<Customer> optCust = customerDao.viewByCustomerId1(custId);
		
		if(!optCust.isPresent())
			throw new CustomerNotFoundException(OrderConstants.CUSTOMER_NOT_FOUND);**/
		
		List<OrderMedicine> lst = orderMedicineDao.viewOrderByCustId(custId);
		
		if(lst.isEmpty())
			throw new OrderMedicineNotFoundException(OrderConstants.ORDER_EMPTY);
		
		//lst.sort((e1,e2)->e1.getOrderDate().compareTo(e2.getOrderDate()));
		return lst;
	}
	

	@Override
	public List<OrderMedicineDetails> displayOrderDetails(Integer orderId) throws OrderMedicineNotFoundException {
		/**Optional<OrderMedicine> optOrder = orderMedicineDao.findById(orderId);
		if(!optOrder.isPresent())
			throw new OrderMedicineNotFoundException(OrderConstants.ORDER_NOT_FOUND);**/
		
		List<OrderMedicineDetails> orderMediDetails = orderMedcineDetailDao.getMedicineDetailsInOrder(orderId);
		
		if(orderMediDetails.isEmpty())
			throw new OrderMedicineNotFoundException(OrderConstants.ORDER_EMPTY);
		
		//orderMediDetails.sort((e1,e2)->e1.getOrderMedicineId().compareTo(e2.getOrderMedicineId()));
		
		return orderMediDetails;
	}

}
