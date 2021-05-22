package com.cg.oam.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oam.dao.ICategoryDao;
import com.cg.oam.dao.IMedicineDao;
import com.cg.oam.dto.MedicineDto;
import com.cg.oam.entities.Category;
import com.cg.oam.entities.Medicine;
import com.cg.oam.exceptions.CategoryNotFoundException;
import com.cg.oam.exceptions.MedicineNotFoundException;
import com.cg.oam.util.MedicineConstants;

/**
 * @author Arghya Sengupta
 * @Version 
 * Description - This service class contains the methods for adding a new medicine for a given category, view the medicines for a given category, view the medicine by Id
 */
@Service
@Transactional
public class MedicineServiceImpl implements IMedicineService {
	@Autowired
	private IMedicineDao medicinedao;//repository object(autowired)
	@Autowired
	private ICategoryDao categorydao;//repository object(autowired)
	
	/**
	 * Method: addMedicine
	 * @Override: It is used to override the JpaRepository methods for performing CRUD operations. 
	 * @Param CategoryDto catdto
	 * @return Integer value i.e., medicine ID
	 * Description: This methods returns the medicine ID after adding the medicine for a specific category instances in the database.
	 * @CreatedAt: 
	**/

	@Override
	public Integer addMedicine(MedicineDto medicineDto) throws CategoryNotFoundException {
		Optional<Category> category = categorydao.findById(medicineDto.getCategoryId());
		if (!category.isPresent())
			throw new CategoryNotFoundException();
	
		Medicine newMedicine = new Medicine();
		newMedicine.setMedicineId(medicineDto.getMedicineId());
		newMedicine.setCompanyName(medicineDto.getCompanyName());
		newMedicine.setMfd(medicineDto.getMfd());
		newMedicine.setExpiryDate(medicineDto.getExpiryDate());
		newMedicine.setImage(medicineDto.getImage());
		newMedicine.setMedicineName(medicineDto.getMedicineName());
		newMedicine.setMedicineCost(medicineDto.getMedicineCost());
		newMedicine.setStock(medicineDto.getStock());
		
		Category newCategory = category.get();
		newMedicine.setCategory(newCategory);
		
		Medicine addedMedicine = medicinedao.save(newMedicine);
		return addedMedicine.getMedicineId();
	}

	/**
	 * Method: ViewMedicineByCategory
	 * @Override: It is used to override the JpaRepository methods for performing CRUD operations. 
	 * @Param MedicineDto meds
	 * @return List of medicine
	 * Description: This methods returns the List of medicine for a given category instances from the database.
	 * @CreatedAt: 
	**/
	@Override
	public List<Medicine> getMedicineByCategoryName(String categoryName) throws MedicineNotFoundException {
		List<Medicine> medicineList = medicinedao.medicineByCategoryName(categoryName);
		if (medicineList.isEmpty())
			throw new MedicineNotFoundException();
		return medicineList;

	}
	
	/**
	 * Method: ViewMedicineByMedicineId
	 * @Override: It is used to override the JpaRepository methods for performing CRUD operations. 
	 * @Param MedicineDto meds
	 * @return string
	 * Description: This methods returns the name of medicine for a specific ID in the database.
	 * @CreatedAt: 
	**/
	@Override
	public Medicine getMedicineByMedicineId(Integer medicineId) throws MedicineNotFoundException {
		Optional<Medicine> optMedicine = medicinedao.findById(medicineId);
		if (!optMedicine.isPresent())
			throw new MedicineNotFoundException(MedicineConstants.MEDICINE_NOT_FOUND);
		return optMedicine.get();
	}
}
