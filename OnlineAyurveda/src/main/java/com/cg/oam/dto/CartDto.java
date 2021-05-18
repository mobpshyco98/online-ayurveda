package com.cg.oam.dto;

import javax.validation.constraints.NotNull;

public class CartDto {

	private Integer cartId;
	
	@NotNull(message = "qty cannot be null")
	private Integer qty;
	
	@NotNull(message = "customerId cannot be null")
	private Integer custId;
	
	@NotNull(message = "medicineId cannot be null")
	private Integer medicineId;

	public CartDto() {

	}

	public CartDto(Integer qty, Integer custId, Integer medicineId) {
		super();
		this.qty = qty;
		this.custId = custId;
		this.medicineId = medicineId;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public Integer getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}

}