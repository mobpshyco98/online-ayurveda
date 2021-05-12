package com.cg.oam.entities;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cg_medicine")
public class Medicine {

	@Id
	@Column(name="medicine_id")
	private String medicineId;
	
	@Column(name="medicine_name")
	private String medicineName;
	
	@Column(name="medicine_cost")
	private float medicineCost;
	
	@Column(name="mfd")
	private LocalDate mfd;
	
	@Column(name="expiry_date")
	private LocalDate expiryDate;
	
	@Column(name="company_name")
	private String companyName;
	
	@ManyToOne
	private Category category;
	
	public String getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public float getMedicineCost() {
		return medicineCost;
	}
	public void setMedicineCost(float medicineCost) {
		this.medicineCost = medicineCost;
	}
	public LocalDate getMfd() {
		return mfd;
	}
	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
}