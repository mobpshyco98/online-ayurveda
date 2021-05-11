package com.cg.oam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cg_cart")
public class Cart {
	
	@Id
	@Column(name="cart_id")
	private int cartId;
	
	
	private Cart_Medicine cartMedicine;
	
	
	private Customer customer;
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public Cart_Medicine getCartMedicine() {
		return cartMedicine;
	}
	public void setCartMedicine(Cart_Medicine cartMedicine) {
		this.cartMedicine = cartMedicine;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return cartId + " " + cartMedicine + " " + customer;
	}
	
	
}