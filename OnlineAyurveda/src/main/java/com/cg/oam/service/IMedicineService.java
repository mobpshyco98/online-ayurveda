package com.cg.oam.service;

import java.util.List;

import com.cg.oam.dto.MedicineDto;
import com.cg.oam.entities.Medicine;
import com.cg.oam.exceptions.CategoryNotFoundException;
import com.cg.oam.exceptions.MedicineNotFoundException;

public interface IMedicineService {

	public Integer addMedicine(MedicineDto medicineDto) throws CategoryNotFoundException;

	public List<Medicine> getMedicineByCategoryName(String categoryName) throws MedicineNotFoundException;

	public Medicine getMedicineByMedicineId(Integer medicineId) throws MedicineNotFoundException;
	
	public boolean editMedicine(MedicineDto medicinedto) throws CategoryNotFoundException ;
	
	public boolean deleteMedicine(Integer medicineId) throws MedicineNotFoundException;
}
