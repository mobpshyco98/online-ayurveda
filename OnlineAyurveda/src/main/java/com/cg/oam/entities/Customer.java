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

	@OneToMany(mappedBy = "customer_order")
	@JsonIgnore
	private Set<Order> customer_order;

	@OneToOne
	private Cart cart; 
	
	Customer() {
		
	}

	public Set<Order> getCustomer_order() {
		return customer_order;
	}

	public void setCustomer_order(Set<Order> customer_order) {
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

	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return customerId + " " + customerName + " ";
//	}

}
