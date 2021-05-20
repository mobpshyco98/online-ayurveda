package com.cg.oam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oam.dto.SuccessMessage;
import com.cg.oam.exceptions.OrderIdInvalidException;
import com.cg.oam.service.IOrderService;
import com.cg.oam.util.OrderMedicineConstants;

@RestController
public class OrderRestController {

	@Autowired
	private IOrderService service;

	@DeleteMapping("removeorder/{orderid}")
	public SuccessMessage removeItemsByOrderId(@PathVariable Integer orderid) throws OrderIdInvalidException {
		service.removeItemsByOrderId(orderid);
		return new SuccessMessage(OrderMedicineConstants.ORDER_CANCELLED);
	}

}
