package com.cg.oam.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cg.oam.util.MedicineSpecificationConstants;

public class MedicineSpecificationsDto {

	@NotBlank(message = MedicineSpecificationConstants.SPEC_NAME_REQUIRED)
	private String specName;

	@NotBlank(message = MedicineSpecificationConstants.SPEC_VALUE_REQUIRED)
	private String specValue;

	@NotNull(message = MedicineSpecificationConstants.MEDICINE_ID_REQUIRED)
	private Integer medicineId;
	
	private Integer specId;


	public MedicineSpecificationsDto() {
		
	}
	
	
	public MedicineSpecificationsDto(String specName, String specValue) {
		super();
		this.specName = specName;
		this.specValue = specValue;
	}



	public MedicineSpecificationsDto(String specName, Integer medicineId) {
		super();
		this.specName = specName;
		this.medicineId = medicineId;
	}
	
	
	public MedicineSpecificationsDto(Integer medicineId, Integer specId) {
		super();
		this.medicineId = medicineId;
		this.specId = specId;
	}

	
	
	public MedicineSpecificationsDto(Integer medicineId) {
		super();
		this.medicineId = medicineId;
	}


	public MedicineSpecificationsDto(String specName, String specValue, Integer medicineId, Integer specId) {
		super();
		this.specName = specName;
		this.specValue = specValue;
		this.medicineId = medicineId;
		this.specId = specId;
	}
	

	public MedicineSpecificationsDto(Integer specId, String specName, String specValue) {
		super();
		this.specName = specName;
		this.specValue = specValue;
		this.specId = specId;
	}

	public MedicineSpecificationsDto(String specName, String specValue, Integer medicineId) {
		super();
		this.specName = specName;
		this.specValue = specValue;
		this.medicineId = medicineId;
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

	public Integer getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}
	
	
}
