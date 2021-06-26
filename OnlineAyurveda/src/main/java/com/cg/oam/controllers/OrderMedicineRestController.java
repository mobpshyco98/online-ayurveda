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
	
	/**
	 * Method: addOrderMedicine
	 * @Param OrderMedicineDto medicineDto, BindingResult br
	 * @return SuccessMessage along with order ID
	 * @postMapping: ("addordermedicine")It is used to handle the HTTP Post requests matched with given URI Expression
	 * @RequestBody: (OrderMedicineDto medicineDto)Injects the request body that contains JSON to the method argument using HttpMessageConverters
	 * @Valid: It validates the bean and injects the errors in Spring BindingResult instance.
	 * @throws throws Validate Exception if the values entered in JSON body doesn't match with the validations given in the Dto class,
	 * 		   throws CustomerNotFoundException if valid customerId is not provided
	 * 		   throws EmptyCartException if cartId is empty	
	 * Description: This methods returns a SuccessMessage along with the order ID after adding the order_medicine instances in the database.
	 * @CreatedAt: 
	**/
	
	@PostMapping("addordermedicine")
	public SuccessMessage addOrderMedicine(@Valid @RequestBody OrderMedicineDto medicineDto, BindingResult br) 
			throws CustomerNotFoundException, EmptyCartException, ValidateException {
		
		System.out.println("adding order");
		
		if (br.hasErrors())
			throw new ValidateException(br.getFieldErrors());
		
		int medicineOrderId = orderMedicineService.createOrder(medicineDto);
		return new SuccessMessage(OrderConstants.ORDER_CREATED+medicineOrderId);
	}
	
	/**
	 * Method: viewOrderByUserId
	 * @GetMapping:It is used to handle the HTTP get requests matched with given URI Expression
	 * @Param String contactNo
	 * @PathVariable: extract values from the URI path to method argument
	 * @return List of customer instance present in the cart table and Http response status as OK.
	 * @throws throws CustomerNotFound exception if the contact number is not found
	 * Description: This methods returns customer instances.
	 * @CreatedAt: 
	**/
	
	@GetMapping("viewordersbycustid/{custid}")
	public List<OrderMedicine> viewOrderByUserId(@PathVariable("custid") Integer custId) throws OrderMedicineNotFoundException, CustomerNotFoundException{
		return orderMedicineService.viewOrderByCustomerId(custId);
	}
	
	/**
	 * Method: viewOrderByUserId
	 * @GetMapping:It is used to handle the HTTP get requests matched with given URI Expression
	 * @Param String contactNo
	 * @PathVariable: extract values from the URI path to method argument
	 * @return List of customer instance present in the cart table and Http response status as OK.
	 * @throws throws CustomerNotFound exception if the contact number is not found
	 * Description: This methods returns order instances.
	 * @CreatedAt: 
	**/
	
	@GetMapping("vieworderdetails/{orderId}")
	public List<OrderMedicineDetails> viewOrderDetails(@PathVariable("orderId") Integer orderId) throws OrderMedicineNotFoundException{
		return orderMedicineService.displayOrderDetails(orderId);
	}
}

