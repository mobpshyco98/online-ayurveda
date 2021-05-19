package com.cg.oam.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cg_order")
public class OrderMedicine {

	@Id
	@Column(name = "order_id")
	@SequenceGenerator(name = "seq1", sequenceName = "cart_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
	private Integer orderId;

	@Column(name = "order_date")
	private LocalDate orderDate;

	@Column(name = "order_status")
	private String orderStatus;

	@Column(name = "total_cost")
	private double totalCost;

	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	private Customer customer;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double d) {
		this.totalCost = d;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return orderId + " " + orderDate + " " + totalCost + " " + orderStatus;
	}
}
