package com.cg.oam.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oam.dto.CategoryDto;
import com.cg.oam.dto.MedicineDto;
import com.cg.oam.dto.SuccessMessage;
import com.cg.oam.entities.Category;
import com.cg.oam.entities.Medicine;
import com.cg.oam.exceptions.CategoryNotFoundException;
import com.cg.oam.exceptions.MedicineNotFoundException;
import com.cg.oam.service.ICategoryService;
import com.cg.oam.service.IMedicineService;

@RestController
public class CategoryRestContoller {

	@Autowired
	private ICategoryService service;
	@Autowired
	private IMedicineService medicine;

	Logger logger = LoggerFactory.getLogger(CartRestController.class);

	@PostMapping("addcategory")
	public SuccessMessage addCategory(@RequestBody CategoryDto categorydto, BindingResult br)
			throws CategoryNotFoundException {
		Integer categoryId = service.addCategory(categorydto);
		SuccessMessage successMessage = new SuccessMessage("Your Generated Category ID " + categoryId);
		return successMessage;

	}

	@GetMapping("viewallcategory")
	public List<Category> viewAllCategory() throws CategoryNotFoundException {
		List<Category> categoryLst = service.viewAllCategory();
		if (categoryLst.isEmpty())
			throw new CategoryNotFoundException("The Category Table Is Empty");
		return categoryLst;
	}

	@GetMapping("viewallmedicinebycategory/{categoryname}")
	public List<Medicine> getMedicineByCategoryName(@PathVariable("categoryname") String categoryName)
			throws MedicineNotFoundException, CategoryNotFoundException {
		
		List<Medicine> MedicineLst = medicine.getMedicineByCategoryName(categoryName);
		if (MedicineLst.isEmpty())
			throw new MedicineNotFoundException("No Medicine Found in this Category");
		return MedicineLst;
	}

	@PostMapping("addmedicine")
	public SuccessMessage addMedicine(@RequestBody MedicineDto medicineDto) throws CategoryNotFoundException {
		Integer medicineDetails = medicine.addMedicine(medicineDto);
		return new SuccessMessage("Medicine Addded, ID is" + medicineDetails);
	}

}
