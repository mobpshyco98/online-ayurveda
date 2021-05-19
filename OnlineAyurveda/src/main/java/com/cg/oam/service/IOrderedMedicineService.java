package com.cg.oam.service;

import java.util.List;

import com.cg.oam.entities.OrderMedicine;
import com.cg.oam.entities.OrderMedicineDetails;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.exceptions.EmptyCartException;
import com.cg.oam.exceptions.OrderMedicineNotFoundException;

public interface IOrderedMedicineService {
	
	public Integer createOrder(Integer customerId) throws CustomerNotFoundException, EmptyCartException;
		
	public List<OrderMedicine> viewOrderByUserId(Integer custId) throws CustomerNotFoundException, OrderMedicineNotFoundException;
	
	public List<OrderMedicineDetails> displayOrderDetails(Integer orderId) throws OrderMedicineNotFoundException;

}
