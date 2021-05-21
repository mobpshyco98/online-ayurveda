package com.cg.oam.controllers;


import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.oam.dto.CustomerDto;
import com.cg.oam.dto.SuccessMessage;
import com.cg.oam.entities.Customer;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.exceptions.ValidateException;
import com.cg.oam.service.CustomerServiceImpl;

@RestController
public class CustomerRestController {

	@Autowired
	CustomerServiceImpl customerService; //injects the CustomerServiceImpl dependency into customerService
	
	Logger logger = LoggerFactory.getLogger(CustomerRestController.class);
	
	/**
	 * Method: addCustomer
	 * @Param CustomerDto custDto, BindingResult br
	 * @return SuccessMessage along with customer ID
	 * @postMapping: It is used to handle the HTTP Post requests matched with given URI Expression
	 * @RequestBody: Injects the request body that contains JSON to the method argument using HttpMessageConverters
	 * @Valid: It validates the bean and injects the errors in Spring BindingResult instance.
	 * @throws throws Validate Exception if the values entered in JSON body doesn't match with the validations given in the Dto class
	 * Description: This methods returns a SuccessMessage along with the customer ID after adding the customer instances in the database.
	 * @CreatedAt: 
	**/
	@PostMapping("addcustomer")
	public SuccessMessage addCustomer(@Valid @RequestBody CustomerDto custDto, BindingResult br ) throws ValidateException {
		logger.info("Add customer");
		
		if(br.hasErrors())
			throw new ValidateException(br.getFieldErrors());
		
		int cid = customerService.addCustomer(custDto);
		return new SuccessMessage("customer added with Customer ID " + cid);
		
	}
	
	/**
	 * Method: viewCustomerById
	 * @GetMapping:It is used to handle the HTTP get requests matched with given URI Expression
	 * @Param Integer custId
	 * @PathVariable: extract values from the URI path to method argument
	 * @return customer instance for the given ID
	 * @throws throws CustomerNotFound exception if the ID is not found
	 * Description: This methods returns customer instances .
	 * @CreatedAt: 
	**/
	@GetMapping("viewbyid/{custid}")
	public Customer viewCustomerById(@PathVariable("custid") Integer custId) throws CustomerNotFoundException {
		return customerService.viewCustomerById(custId);
	}
	
	/**
	 * Method: viewCustomer
	 * @GetMapping:It is used to handle the HTTP get requests matched with given URI Expression
	 * @Param String contactNo
	 * @PathVariable: extract values from the URI path to method argument
	 * @return customer instance for the given contact number
	 * @throws throws CustomerNotFound exception if the contact number is not found
	 * Description: This methods returns customer instances.
	 * @CreatedAt: 
	**/
	@GetMapping("viewbycontactno/{contactno}")
	public Optional<Customer> viewCustomer(@PathVariable("contactno") String contactNo) throws CustomerNotFoundException {
		return customerService.viewCustomer(contactNo);
	}
	
	/**
	 * Method: editCustomer
	 * @putMapping:It is used to handle the HTTP PUT requests matched with given URI Expression
	 * @Param CustomerDto custDto, BindingResult br
	 * @Valid: It validates the bean and injects the errors in Spring BindingResult instance.
	 * @RequestBody Injects the request body that contains JSON to the method argument using HttpMessageConverters
	 * @return SuccessMessage
	 * @throws throws Validate Exception if the values entered in JSON body doesn't match with the validations given in the Dto class and CustomerNotFound Exception if the ID is not found
	 * Description: This methods returns a SuccessMessage after editing the customer instances.
	 * @CreatedAt: 
	**/
	@PutMapping("editcustomer")
	public SuccessMessage editCustomer(@Valid @RequestBody CustomerDto custDto, BindingResult br) throws CustomerNotFoundException, ValidateException {
		if(br.hasErrors())
			throw new ValidateException(br.getFieldErrors());
		customerService.editCustomer(custDto);
		return new SuccessMessage("Customer edited successfully");
	}
}
