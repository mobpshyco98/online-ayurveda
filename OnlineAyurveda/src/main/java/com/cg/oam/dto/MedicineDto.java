package com.cg.oam.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.NotNull;

public class MedicineDto {

	private Integer medicineId;

	@NotBlank(message = "medicineName cannot be blank ")
	private String medicineName;

	@NotNull(message = "medicine cost cannot be null")
	private Float medicineCost;

	@NotNull(message = "manufacturing date cannot be blank")
	private LocalDate mfd;

	@NotNull(message = "expiry date cannot be blank")
	private LocalDate expiryDate;

	@NotBlank(message = "company name cannot be blank")
	private String companyName;

	@NotNull(message = "category id cannot be null")
	private Integer categoryId;

	@NotNull(message = "stock no. cannot be blank")
	private Integer stock;

	@NotBlank(message = "Image cannot be blank")
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