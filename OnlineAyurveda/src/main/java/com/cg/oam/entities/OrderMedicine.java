package com.cg.oam.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	@Column(name = "dispatch_date")
	private LocalDate dispatchDate;

	@Column(name = "total_cost")
	private float totalCost;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	private Customer customer_order = new Customer();

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

//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString();
//	}

}
