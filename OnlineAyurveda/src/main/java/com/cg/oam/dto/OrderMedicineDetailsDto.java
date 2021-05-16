package com.cg.oam.dto;

import javax.persistence.Column;

import com.cg.oam.entities.Medicine;
import com.cg.oam.entities.OrderMedicine;

public class OrderMedicineDetailsDto {

	private Integer orderMedicineId;

	private Medicine medicine;

	@Column(name = "qty")
	private Integer qty;

	public OrderMedicine getOrderMedicine() {
		return orderMedicine;
	}

	public void setOrderMedicine(OrderMedicine orderMedicine) {
		this.orderMedicine = orderMedicine;
	}

	private OrderMedicine orderMedicine;

	public OrderMedicineDetailsDto() {

	}

	public OrderMedicineDetailsDto(Medicine medicine, Integer qty, OrderMedicine orderMedicine) {
		super();
		this.medicine = medicine;
		this.qty = qty;
		this.orderMedicine = orderMedicine;
	}

	public Integer getOrderMedicineId() {
		return orderMedicineId;
	}

	public void setOrderMedicineId(Integer orderMedicineId) {
		this.orderMedicineId = orderMedicineId;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return orderMedicineId + " " + medicine + " " + qty;
//	}

}