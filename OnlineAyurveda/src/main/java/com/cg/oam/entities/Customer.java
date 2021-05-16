package com.cg.oam.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cg_customer")
public class Customer {

	@Id
	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "contact_no")
	private String contactNo;

	@Column(name = "address")
	private String address;

	@Column(name = "location")
	private String location;

	@OneToMany(mappedBy = "customer_order")
	@JsonIgnore
	private Set<OrderMedicine> customer_order;

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
