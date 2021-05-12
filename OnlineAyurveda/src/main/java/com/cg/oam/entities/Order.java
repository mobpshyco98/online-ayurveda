package com.cg.oam.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cg_order")
public class Order {

	@Id
	@Column(name = "order_id")
	private int orderId;

	@Column(name = "order_date")
	private LocalDate orderDate;

	@Column(name = "dispatch_date")
	private LocalDate dispatchDate;

	@Column(name = "total_cost")
	private float totalCost;

	private Customer customer_order = new Customer();

//	private Order_Medicine orderMedicine;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

//	public Order_Medicine getOrderMedicine() {
//		return orderMedicine;
//	}
//
//	public void setOrderMedicine(Order_Medicine orderMedicine) {
//		this.orderMedicine = orderMedicine;
//	}

	public LocalDate getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public Customer getCustomer_order() {
		return customer_order;
	}

	public void setCustomer_order(Customer customer_order) {
		this.customer_order = customer_order;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
