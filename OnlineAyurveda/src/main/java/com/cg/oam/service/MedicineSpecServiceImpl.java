package com.cg.oam.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oam.dao.IMedicineDao;
import com.cg.oam.dao.IMedicineSpecificationDao;
import com.cg.oam.dto.MedicineSpecificationsDto;
import com.cg.oam.entities.Medicine;
import com.cg.oam.entities.MedicineSpecifications;
import com.cg.oam.exceptions.MedicineNotFoundException;
import com.cg.oam.exceptions.NoSpecsException;
import com.cg.oam.util.MedicineSpecificationConstants;

@Service
public class MedicineSpecServiceImpl implements IMedicineSpecService {

	@Autowired
	private IMedicineSpecificationDao medSpecsDao;

	@Autowired
	private IMedicineDao medDao;

	Logger logger = LoggerFactory.getLogger(MedicineSpecServiceImpl.class);

	@Override
	@Transactional
	public Integer addSpecs(MedicineSpecificationsDto medSpecsDto) throws MedicineNotFoundException {
		Optional<Medicine> optMed = medDao.findById(medSpecsDto.getMedicineId());
		logger.info("" + optMed.isPresent());
		if (!optMed.isPresent())
			throw new MedicineNotFoundException(MedicineSpecificationConstants.MEDICINE_NOT_FOUND);

		MedicineSpecifications medSpecs = new MedicineSpecifications();

		medSpecs.setSpecName(medSpecsDto.getSpecName());
		medSpecs.setSpecValue(medSpecsDto.getSpecValue());
		medSpecs.setMedicine(optMed.get());
		MedicineSpecifications med = medSpecsDao.save(medSpecs);
		return med.getSpecId();
	}

	@Override
	public List<MedicineSpecifications> getMedSpecsById(Integer medicineId) throws MedicineNotFoundException, NoSpecsException {
		Optional<Medicine> optMed = medDao.findById(medicineId);
		
		if(!optMed.isPresent())
			throw new MedicineNotFoundException(MedicineSpecificationConstants.MEDICINE_NOT_FOUND);
		
		List<MedicineSpecifications> lst = medSpecsDao.getSpecifications(medicineId);
		
		logger.info("" + lst.isEmpty());
		if(lst.isEmpty())
			throw new NoSpecsException(MedicineSpecificationConstants.MEDICINE_SPEC_EMPTY);
		lst.sort((m1, m2) -> m1.getSpecName().compareTo(m2.getSpecName()));
		return lst;
		
	}

}
