package com.cg.oam.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cg.oam.entities.OrderMedicine;

public class CustomerDto {

	private Integer customerId;
	@NotBlank(message = "Customer name must not be blank")
	@Pattern(regexp = "([a-zA-Z]+)|([a-zA-Z]+[\\s][a-zA-Z]+)", message = "Name must contain alphabets")
	private String customerName;

	@Size(min = 10, message = "Contact number must be a 10 digit number")
	private String contactNo;

	@NotBlank(message = "Address cannot be blank")
	private String address;

	@NotBlank(message = "Customer name must not be blank")
	private String location;

	private Set<OrderMedicine> customer_order;

	public CustomerDto() {

	}

	public CustomerDto(String customerName, String contactNo, String address, String location) {
		super();
		this.customerName = customerName;
		this.contactNo = contactNo;
		this.address = address;
		this.location = location;
	}

	public CustomerDto(String customerName, String contactNo, String address, String location,
			Set<OrderMedicine> customer_order) {
		super();
		this.customerName = customerName;
		this.contactNo = contactNo;
		this.address = address;
		this.location = location;
		this.customer_order = customer_order;
	}

	public Set<OrderMedicine> getCustomer_order() {
		return customer_order;
	}

	public void setCustomer_order(Set<OrderMedicine> customer_order) {
		this.customer_order = customer_order;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return customerId + " " + customerName + " ";
//	}

}
