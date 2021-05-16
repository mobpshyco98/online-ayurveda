package com.cg.oam.dto;

public class CartDto {

	private Integer cartId;

	private Integer qty;

	private Integer custId;

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