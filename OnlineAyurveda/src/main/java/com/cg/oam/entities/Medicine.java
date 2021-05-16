package com.cg.oam.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cg_medicine")
public class Medicine {

	@Id
	@Column(name = "medicine_id")
	private Integer medicineId;

	@Column(name = "medicine_name")
	private String medicineName;

	@Column(name = "medicine_cost")
	private Float medicineCost;

	@Column(name = "mfd")
	private LocalDate mfd;

	@Column(name = "expiry_date")
	private LocalDate expiryDate;

	@Column(name = "company_name")
	private String companyName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "catergory_id", referencedColumnName = "category_id")
	private Category category = new Category();

	@Column(name = "stock")
	private Integer stock;

	@Column(name = "image", length = 25)
	private String image;

	public Integer getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public Float getMedicineCost() {
		return medicineCost;
	}

	public void setMedicineCost(Float medicineCost) {
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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString();
//	}

}