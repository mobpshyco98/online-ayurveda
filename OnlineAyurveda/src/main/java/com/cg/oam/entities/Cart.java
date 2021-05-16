package com.cg.oam.entities;

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
@Table(name = "cg_cart")
public class Cart {

	@Id
	@Column(name = "cart_id")
	@SequenceGenerator(name = "seq1", sequenceName = "cart_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
	private Integer cartId;

 	@Column(name = "quantity")
	private Integer qty;

	@ManyToOne
	@JoinColumn(name = "cust_id", referencedColumnName = "customer_id")
	private Customer cust;

	@ManyToOne
	@JoinColumn(name = "medicine_id", referencedColumnName = "medicine_id")
	private Medicine medicine;

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

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	
	
}