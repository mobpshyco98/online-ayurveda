package com.cg.oam.dto;

import com.cg.oam.entities.Medicine;


public class MedicineSpecificationsDto {

	
	private Integer specId;


	private String specName;


	private String specValue;

	
	private Medicine medicine;
	
	public MedicineSpecificationsDto() {
		
	}
	
	public MedicineSpecificationsDto(String specName, String specValue, Medicine medicine) {
		super();
		this.specName = specName;
		this.specValue = specValue;
		this.medicine = medicine;
	}

	public Integer getSpecId() {
		return specId;
	}

	public void setSpecId(Integer specId) {
		this.specId = specId;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public String getSpecValue() {
		return specValue;
	}

	public void setSpecValue(String specValue) {
		this.specValue = specValue;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	
	
}
