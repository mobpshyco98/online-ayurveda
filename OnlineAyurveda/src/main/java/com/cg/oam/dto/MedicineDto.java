package com.cg.oam.dto;

import java.time.LocalDate;

import com.cg.oam.entities.Category;

public class MedicineDto {

	private Integer medicineId;

	private String medicineName;

	private Float medicineCost;

	private LocalDate mfd;

	private LocalDate expiryDate;

	private String companyName;

	private Category category = new Category();

	private Integer stock;

	private String image;

	public MedicineDto() {

	}

	public MedicineDto(String medicineName, Float medicineCost, LocalDate mfd, LocalDate expiryDate, String companyName,
			Category category, Integer stock, String image) {
		super();
		this.medicineName = medicineName;
		this.medicineCost = medicineCost;
		this.mfd = mfd;
		this.expiryDate = expiryDate;
		this.companyName = companyName;
		this.category = category;
		this.stock = stock;
		this.image = image;
	}

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