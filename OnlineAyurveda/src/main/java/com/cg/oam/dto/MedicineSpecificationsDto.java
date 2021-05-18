package com.cg.oam.dto;

import javax.validation.constraints.NotNull;

import com.cg.oam.entities.Medicine;


public class MedicineSpecificationsDto {


	private String specName;


	private String specValue;

	
	private Integer medicineId;
	
	public MedicineSpecificationsDto() {
		
	}
	
	public MedicineSpecificationsDto(String specName, String specValue, Integer medicineId) {
		super();
		this.specName = specName;
		this.specValue = specValue;
		this.medicineId = medicineId;
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

	public Integer getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}
	
	
}
