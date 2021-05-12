package com.cg.oam.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cg_cart")
public class Cart {

	@Id
	@Column(name = "cart_id")
	private Integer cartId;

	@Column(name = "Medicine")
	private Medicine meds;

	@Column(name = "quantity")
	private Integer qty;

	private Customer cust;

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Medicine getMeds() {
		return meds;
	}

	public void setMeds(Medicine meds) {
		this.meds = meds;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}	
}