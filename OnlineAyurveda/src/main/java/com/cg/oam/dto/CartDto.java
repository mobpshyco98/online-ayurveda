package com.cg.oam.dto;

import com.cg.oam.entities.Medicine;

public class CartDto {

	private Integer cartId;

	private Integer qty;

	private CustomerDto cust;

	private Medicine medicine;
	
	public CartDto() {
		
	}

	public CartDto(Integer qty, CustomerDto cust, Medicine medicine) {
		super();
		this.qty = qty;
		this.cust = cust;
		this.medicine = medicine;
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

	public CustomerDto getCust() {
		return cust;
	}

	public void setCust(CustomerDto cust) {
		this.cust = cust;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

}