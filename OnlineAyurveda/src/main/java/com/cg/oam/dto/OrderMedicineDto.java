package com.cg.oam.dto;

import java.time.LocalDate;

public class OrderMedicineDto {

	private Integer orderId;
	
	private LocalDate orderDate;

	private LocalDate dispatchDate;

	private Float totalCost;

	private CustomerDto customer_order = new CustomerDto();

	
	public OrderMedicineDto(LocalDate orderDate, LocalDate dispatchDate, CustomerDto customer_order) {
		super();
		this.orderDate = orderDate;
		this.dispatchDate = dispatchDate;
		this.customer_order = customer_order;
	}

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

	public Float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}

	public CustomerDto getCustomer_order() {
		return customer_order;
	}

	public void setCustomer_order(CustomerDto customer_order) {
		this.customer_order = customer_order;
	}

//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString();
//	}

}
