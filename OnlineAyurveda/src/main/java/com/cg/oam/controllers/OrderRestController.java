package com.cg.oam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oam.dto.SuccessMessage;
import com.cg.oam.exceptions.OrderIdInvalidException;
import com.cg.oam.service.IOrderService;
import com.cg.oam.util.OrderMedicineConstants;

/**
 * @author - Soumyajit Ghosh
 * @Version - 1.0
 * Description - This controller class contains methods for canceling an order by orderId
 **/

@RestController
public class OrderRestController {

	@Autowired
	private IOrderService service;
	
	/**
	 * Method: removeItemsByOrderId
	 * @Param Integer orderId
	 * @return SuccessMessage
	 * @DeleteMapping: It is used to handle the HTTP Delete requests matched with given URI Expression
	 * @PathVariable: It extracts values from the URI path to method argument
	 * @throws throws OrderIdInvalidException if orderId is not present
	 * Description: This methods returns a SuccessMessage after canceling an order using orderId 
	 * @CreatedAt: 21-May-2021
	**/

	@DeleteMapping("removeorder/{orderid}")
	public SuccessMessage removeItemsByOrderId(@PathVariable Integer orderid) throws OrderIdInvalidException {
		service.removeItemsByOrderId(orderid);
		return new SuccessMessage(OrderMedicineConstants.ORDER_CANCELLED);
	}

}
