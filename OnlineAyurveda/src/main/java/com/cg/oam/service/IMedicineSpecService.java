package com.cg.oam.service;

import com.cg.oam.dto.MedicineSpecificationsDto;
import com.cg.oam.exceptions.MedicineNotFoundException;

public interface IMedicineSpecService {
	
	public Integer addSpecs(MedicineSpecificationsDto medSpecsDto) throws MedicineNotFoundException;
	
}
