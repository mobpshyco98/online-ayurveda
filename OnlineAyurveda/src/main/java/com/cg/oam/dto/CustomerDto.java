package com.cg.oam.dto;

import java.util.Set;

import com.cg.oam.entities.OrderMedicine;

public class CustomerDto {

	private Integer customerId;

	private String customerName;

	private String contactNo;

	private String address;

	private String location;

	private Integer customer_order;

	public CustomerDto() {
		
	}

	public CustomerDto(Integer customerId, String customerName, String contactNo, String address, String location,
			Integer customer_order) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactNo = contactNo;
		this.address = address;
		this.location = location;
		this.customer_order = customer_order;
	}

	public CustomerDto(String customerName, String contactNo, String address, String location) {
		super();
		this.customerName = customerName;
		this.contactNo = contactNo;
		this.address = address;
		this.location = location;
	}

	public CustomerDto(String customerName, String contactNo, String address, String location,
			Integer customer_order) {
		super();
		this.customerName = customerName;
		this.contactNo = contactNo;
		this.address = address;
		this.location = location;
		this.customer_order = customer_order;
	}

	public Integer getCustomer_order() {
		return customer_order;
	}

	public void setCustomer_order(Integer customer_order) {
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
