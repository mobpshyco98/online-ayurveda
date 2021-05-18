package com.cg.oam.service;

import com.cg.oam.dto.MedicineSpecificationsDto;
import com.cg.oam.entities.MedicineSpecifications;
import com.cg.oam.exceptions.MedicineNotFoundException;

public interface IMedicineSpecService {
	
	public MedicineSpecifications addSpecs(MedicineSpecificationsDto medSpecsDto) throws MedicineNotFoundException;
	
}
