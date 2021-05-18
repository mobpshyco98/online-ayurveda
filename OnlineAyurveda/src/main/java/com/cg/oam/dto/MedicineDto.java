package com.cg.oam.dto;

import java.time.LocalDate;

public class MedicineDto {

	private Integer medicineId;

	private String medicineName;

	private Float medicineCost;

	private LocalDate mfd;

	private LocalDate expiryDate;

	private String companyName;

	private Integer categoryId;

	private Integer stock;

	private String image;

	public MedicineDto() {

	}

	public MedicineDto(String medicineName, Float medicineCost, LocalDate mfd, LocalDate expiryDate, String companyName,
			Integer categoryId, Integer stock, String image) {
		super();
		this.medicineName = medicineName;
		this.medicineCost = medicineCost;
		this.mfd = mfd;
		this.expiryDate = expiryDate;
		this.companyName = companyName;
		this.categoryId = categoryId;
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

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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