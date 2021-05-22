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
import com.cg.oam.exceptions.ValidateException;
import com.cg.oam.util.CustomerConstants;
import com.cg.oam.util.MedicineSpecificationConstants;

/**
 * @author - Soumyajit Ghosh
 * @Version - 1.0
 * Description - This service class contains methods for adding a new medicine specification, viewing a medicine specification by Medicine Id and editing a medicine specification by Medicine Id
 **/

@Service
public class MedicineSpecServiceImpl implements IMedicineSpecService {

	@Autowired
	private IMedicineSpecificationDao medSpecsDao;

	@Autowired
	private IMedicineDao medDao;

	Logger logger = LoggerFactory.getLogger(MedicineSpecServiceImpl.class);
	
	/**
	 * Method: addSpecs
	 * @Override: It is used to override the JpaRepository methods for performing CRUD operations. 
	 * @Param MedicineSpecificationsDto medSpecsDto
	 * @return Integer value i.e., SpecID
	 * @Throws throws MedicineNotFoundException if the Medicine Id is not found, ValidateException if there are validation errors
	 * Description: This methods returns the specification ID after adding the medicine specification instances in the database
	 * CreatedAt: 18-May-2021
	**/

	@Override
	@Transactional
	public Integer addSpecs(MedicineSpecificationsDto medSpecsDto) throws MedicineNotFoundException, ValidateException {
		Optional<Medicine> optMed = medDao.findById(medSpecsDto.getMedicineId());

		if (!optMed.isPresent()) {
			logger.error(MedicineSpecificationConstants.MEDICINE_NOT_FOUND);
			throw new MedicineNotFoundException(MedicineSpecificationConstants.MEDICINE_NOT_FOUND);
		}

		MedicineSpecifications medSpecs = new MedicineSpecifications();

		medSpecs.setSpecName(medSpecsDto.getSpecName());
		medSpecs.setSpecValue(medSpecsDto.getSpecValue());
		medSpecs.setMedicine(optMed.get());
		MedicineSpecifications med = medSpecsDao.save(medSpecs);
		return med.getSpecId();
	}

	/**
	 * Method: getMedSpecsById
	 * @Override: It is used to override the JpaRepository methods for performing CRUD operations. 
	 * @Param Integer medcineId
	 * @return List i.e., lst
	 * @Throws throws MedicineNotFoundException if the Medicine Id is not found, NoSpecsException if there are no specification available
	 * Description: This methods returns all the specifications for a given medicine Id.
	 * CreatedAt: 19-May-2021
	**/
	
	@Override
	public List<MedicineSpecifications> getMedSpecsById(Integer medicineId)
			throws MedicineNotFoundException, NoSpecsException {
		Optional<Medicine> optMed = medDao.findById(medicineId);

		if (!optMed.isPresent()) {
			logger.error(MedicineSpecificationConstants.MEDICINE_NOT_FOUND);
			throw new MedicineNotFoundException(MedicineSpecificationConstants.MEDICINE_NOT_FOUND);
		}

		List<MedicineSpecifications> lst = medSpecsDao.getSpecifications(medicineId);

		if (lst.isEmpty()) {
			logger.error(MedicineSpecificationConstants.MEDICINE_SPEC_EMPTY);
			throw new NoSpecsException(MedicineSpecificationConstants.MEDICINE_SPEC_EMPTY);
		}
			
		lst.sort((m1, m2) -> m1.getSpecName().compareTo(m2.getSpecName()));
		return lst;

	}

	/**
	 * Method: editSpecs
	 * @Override: It is used to override the JpaRepository methods for performing CRUD operations. 
	 * @Param MedicineSpecificationsDto medSpecsDto
	 * @return Boolean value i.e., true
	 * @Throws throws MedicineNotFoundException if the Medicine Id is not found, NoSpecsException if there are no specification available and ValidateException if there are validation errors
	 * Description: This methods edits the medicine specification for a given medicine Id
	 * CreatedAt: 19-May-2021
	**/
	
	@Override
	@Transactional
	public boolean editSpecs(MedicineSpecificationsDto medSpecsDto) throws MedicineNotFoundException, NoSpecsException, ValidateException {
		Optional<Medicine> optMed = medDao.findById(medSpecsDto.getMedicineId());

		if (!optMed.isPresent()) {
			logger.error(MedicineSpecificationConstants.MED_ID_WRONG);
			throw new MedicineNotFoundException(MedicineSpecificationConstants.MED_ID_WRONG);
		}
			

		Optional<MedicineSpecifications> medSpecs = medSpecsDao.findById(medSpecsDto.getSpecId());
		
		if (!medSpecs.isPresent()) {
			logger.error(MedicineSpecificationConstants.MEDICINE_SPEC_EMPTY);
			throw new NoSpecsException(MedicineSpecificationConstants.MEDICINE_SPEC_EMPTY);
		}
		
		MedicineSpecifications medSpecSet = medSpecs.get();

		medSpecSet.setSpecName(medSpecsDto.getSpecName());
		medSpecSet.setSpecValue(medSpecsDto.getSpecValue());

		medSpecsDao.save(medSpecSet);

		return true;
	}

}
