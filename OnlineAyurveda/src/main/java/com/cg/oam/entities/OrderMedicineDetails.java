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
@Table(name = "cg_order_medicine")
public class OrderMedicineDetails {

	@Id
	@Column(name = "order_medicine_id")
	@SequenceGenerator(name = "seq1", sequenceName = "cart_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
	private Integer orderMedicineId;

	@ManyToOne
	@JoinColumn(name = "medicine_id", referencedColumnName = "medicine_id")
	private Medicine medicine;

	@Column(name = "qty")
	private Integer qty;

	@ManyToOne
	@JoinColumn(name = "order_id",referencedColumnName = "order_id")
	private OrderMedicine orderMedicine;
	
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