package com.cg.oam.service;

import java.util.List;

import com.cg.oam.dto.MedicineSpecificationsDto;
import com.cg.oam.dto.SuccessMessage;
import com.cg.oam.entities.MedicineSpecifications;
import com.cg.oam.exceptions.MedicineNotFoundException;
import com.cg.oam.exceptions.NoSpecsException;
import com.cg.oam.exceptions.ValidateException;

public interface IMedicineSpecService {
	
	public Integer addSpecs(MedicineSpecificationsDto medSpecsDto) throws MedicineNotFoundException, ValidateException;
	public List<MedicineSpecifications> getMedSpecsById(Integer medicineId) throws MedicineNotFoundException, NoSpecsException;
	public boolean editSpecs(MedicineSpecificationsDto medSpecsDto) throws MedicineNotFoundException, NoSpecsException, ValidateException; 
}
