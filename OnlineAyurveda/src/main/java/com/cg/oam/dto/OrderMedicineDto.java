package com.cg.oam.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class OrderMedicineDto {
	
	
	private Integer orderId;
	
	private LocalDate orderDate;
	
	private String orderStatus;

	//private LocalDate dispatchDate;
	
	private Double totalCost;
	
	@NotNull(message = "customerId cannot be null")
	private Integer customerId;
	
	
	
	//private CustomerDto customer_order = new CustomerDto();

	
	
	

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

	/**public LocalDate getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
	}**/
	
	public String getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public OrderMedicineDto(LocalDate orderDate, String orderStatus, Double totalCost,
			Integer customerId) {
		super();
		//this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.totalCost = totalCost;
		this.customerId = customerId;
	}

	public OrderMedicineDto() {
		super();
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
}
