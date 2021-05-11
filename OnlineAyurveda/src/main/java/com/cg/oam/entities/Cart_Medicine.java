package com.cg.oam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cg_cart_med")
public class Cart_Medicine {
	
	@Id
	@Column(name="cart_medicine_id")
	private int cartMedicineId;
	

	private Cart cart;
	
	@Column(name="qty")
	private int qty;
	
	public int getCartMedicineId() {
		return cartMedicineId;
	}
	public void setCartMedicineId(int cartMedicineId) {
		this.cartMedicineId = cartMedicineId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return cartMedicineId + " " + cart + " " + qty;
	}
	
}