package com.cg.oam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cg_order_medicine")
public class Order_Medicine {
	
	@Id
	@Column(name="order_medicine_id")
	private int orderMedicineId;
	
	
	private Medicine medicine;
	
	@Column(name="qty")
	private int qty;
	
	public int getOrderMedicineId() {
		return orderMedicineId;
	}
	public void setOrderMedicineId(int orderMedicineId) {
		this.orderMedicineId = orderMedicineId;
	}
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
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
		return orderMedicineId + " " + medicine + " " + qty;
	}
	
	
}