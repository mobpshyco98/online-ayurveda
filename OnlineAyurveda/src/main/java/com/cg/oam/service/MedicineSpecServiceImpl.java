package com.cg.oam.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oam.dao.IMedicineDao;
import com.cg.oam.dao.IMedicineSpecificationDao;
import com.cg.oam.dto.MedicineDto;
import com.cg.oam.dto.MedicineSpecificationsDto;
import com.cg.oam.entities.Medicine;
import com.cg.oam.entities.MedicineSpecifications;
import com.cg.oam.exceptions.MedicineNotFoundException;


@Service
public class MedicineSpecServiceImpl implements IMedicineSpecService{
	
	@Autowired
	private IMedicineSpecificationDao medSpecsDao;
	
	@Autowired
	private IMedicineDao medDao;
	
	Logger logger = LoggerFactory.getLogger(MedicineSpecServiceImpl.class);

	@Override
	public MedicineSpecifications addSpecs(MedicineSpecificationsDto medSpecsDto) throws MedicineNotFoundException {
		
		Optional<Medicine> optMed = medDao.findById(medSpecsDto.getMedicineId());
		
		logger.info("" + optMed.isPresent());
		if(!optMed.isPresent())
			throw new MedicineNotFoundException("Product Not Found");  //work required
		
		MedicineSpecifications medSpecs = new MedicineSpecifications();
		
		medSpecs.setSpecName(medSpecsDto.getSpecName());
		medSpecs.setSpecValue(medSpecsDto.getSpecValue());
		
		return medSpecsDao.save(medSpecs);		
	}

}
