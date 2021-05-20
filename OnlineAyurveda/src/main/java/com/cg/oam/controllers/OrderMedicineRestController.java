package com.cg.oam.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oam.dto.OrderMedicineDto;
import com.cg.oam.dto.SuccessMessage;
import com.cg.oam.entities.OrderMedicine;
import com.cg.oam.entities.OrderMedicineDetails;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.exceptions.EmptyCartException;
import com.cg.oam.exceptions.OrderMedicineNotFoundException;
import com.cg.oam.exceptions.ValidateException;
import com.cg.oam.service.IOrderedMedicineService;
import com.cg.oam.util.OrderConstants;



@RestController
public class OrderMedicineRestController {
	@Autowired
	private IOrderedMedicineService orderMedicineService;
	
	
	@PostMapping("addordermedicine")
	public SuccessMessage addOrderMedicine(@Valid @RequestBody OrderMedicineDto medicineDto, BindingResult br) 
			throws CustomerNotFoundException, EmptyCartException, ValidateException {
		
		System.out.println("adding order");
		
		if (br.hasErrors())
			throw new ValidateException(br.getFieldErrors());
		
		int medicineOrderId = orderMedicineService.createOrder(medicineDto);
		return new SuccessMessage(OrderConstants.ORDER_CREATED+medicineOrderId);
	}
	
	@GetMapping("viewordersbycustid/{custid}")
	public List<OrderMedicine> viewOrderByUserId(@PathVariable("custid") Integer custId) throws OrderMedicineNotFoundException, CustomerNotFoundException{
		return orderMedicineService.viewOrderByCustomerId(custId);
	}
	
	@GetMapping("vieworderdetails/{orderId}")
	public List<OrderMedicineDetails> viewOrderDetails(@PathVariable("orderId") Integer orderId) throws OrderMedicineNotFoundException{
		return orderMedicineService.displayOrderDetails(orderId);
	}
}

