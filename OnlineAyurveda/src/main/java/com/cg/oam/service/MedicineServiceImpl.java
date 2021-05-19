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

@Service
@Transactional
public class MedicineServiceImpl implements IMedicineService {
	@Autowired
	private IMedicineDao medicinedao;
	@Autowired
	private ICategoryDao categorydao;

	@Override
	public Integer addMedicine(MedicineDto medicineDto) throws CategoryNotFoundException {
		Optional<Category> category = categorydao.findById(medicineDto.getCategoryId());
		if (!category.isPresent())
			throw new CategoryNotFoundException();

		Medicine newMedicine = new Medicine();
		newMedicine.setMedicineId(medicineDto.getMedicineId());
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

	@Override
	public List<Medicine> getMedicineByCategoryName(String categoryName)
			throws CategoryNotFoundException, MedicineNotFoundException {
		Category catergory = categorydao.getCategoryIdByName(categoryName);
		if (catergory == null)
			throw new CategoryNotFoundException("category not found");
		List<Medicine> medicineList = medicinedao.medicineByCategoryName(categoryName);
		if (medicineList.isEmpty())
			throw new MedicineNotFoundException("medicine not found for category");
		return medicineList;

	}

}
