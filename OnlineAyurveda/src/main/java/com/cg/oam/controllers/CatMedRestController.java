package com.cg.oam.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cg.oam.dto.CategoryDto;
import com.cg.oam.dto.MedicineDto;
import com.cg.oam.dto.SuccessMessage;
import com.cg.oam.entities.Category;
import com.cg.oam.entities.Customer;
import com.cg.oam.entities.Medicine;
import com.cg.oam.exceptions.CategoryNameNotFoundException;
import com.cg.oam.exceptions.CategoryNotFoundException;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.exceptions.MedicineNotFoundException;
import com.cg.oam.exceptions.ValidateException;
import com.cg.oam.service.ICategoryService;
import com.cg.oam.service.IMedicineService;

@RestController
public class CatMedRestController {

	@Autowired
	private ICategoryService service;//injects the CategoryServiceImpl dependency into customerService
	@Autowired
	private IMedicineService medicine;//injects the MedicineServiceImpl dependency into customerService

	Logger logger = LoggerFactory.getLogger(CatMedRestController.class);
	
	/**
	 * Method: addCategory
	 * @Param CategoryDto catDto, BindingResult br
	 * @return SuccessMessage along with category ID
	 * @postMapping: It is used to handle the HTTP Post requests matched with given URI Expression
	 * @RequestBody: Injects the request body that contains JSON to the method argument using HttpMessageConverters
	 * @throws throws Validate Exception if the values entered in JSON body doesn't match with the validations given in the Dto class
	 * Description: This methods returns a SuccessMessage along with the category ID after adding the customer instances in the database.
	 * @CreatedAt: 
	**/
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("addCategory")
	public SuccessMessage addCategory(@RequestBody CategoryDto categorydto, BindingResult br)
			throws CategoryNotFoundException {
		Integer categoryId = service.addCategory(categorydto);
		SuccessMessage successMessage = new SuccessMessage("Your Generated Category ID " + categoryId);
		return successMessage;

	}
	/**
	 * Method: viewAllCategory
	 * @GetMapping:It is used to handle the HTTP get requests matched with given URI Expression
	 * @Param List
	 * @return List of Categories
	 * @throws throws CategoryNotFoundException if the ID is not found
	 * Description: This methods returns Category instances .
	 * @CreatedAt: 
	**/
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("viewallcategory")
	public List<Category> viewAllCategory() throws CategoryNotFoundException {
		List<Category> categoryLst = service.viewAllCategory();
		if (categoryLst.isEmpty())
			throw new CategoryNotFoundException("The Category Table Is Empty");
		return categoryLst;
	}
	
	/**
	 * Method: viewCategoryByCategoryName
	 * @GetMapping:It is used to handle the HTTP get requests matched with given URI Expression
	 * @Param List
	 * @PathVariable: extract values from the URI path to method argument
	 * @return List of Medicine instance for the given Category
	 * @throws throws MedicineNotFound,CategoryNotFound exception if the CategoryName is not found
	 * Description: This methods returns Medicine instances .
	 * @CreatedAt: 
	**/
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("viewallmedicinebycategory/{categoryname}")
	public List<Medicine> getMedicineByCategoryName(@PathVariable("categoryname") String categoryName)
			throws MedicineNotFoundException, CategoryNameNotFoundException {
		List<Medicine> MedicineLst = medicine.getMedicineByCategoryName(categoryName);
		if (MedicineLst.isEmpty())
			throw new MedicineNotFoundException("No Product Found in this Category");
		return MedicineLst;
	}

	/**
	 * Method: AddMedicineByCategory
	 * @PostMapping:It is used to handle the HTTP get requests matched with given URI Expression
	 * @Param String CategoryName
	 * @Valid: It validates the bean and injects the errors in Spring BindingResult instance.
	 * @RequestBody: Injects the request body that contains JSON to the method argument using HttpMessageConverters
	 * @return Medicine instance for the given ID
	 * @throws throws CategoryNotFound exception,ValidateException if the ID is not found
	 * Description: This methods returns medicine instances .
	 * @CreatedAt: 
	**/
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("addMedicinebycategory")
	public SuccessMessage addMedicine(@Valid @RequestBody MedicineDto medicineDto, BindingResult br) throws CategoryNotFoundException, ValidateException {
		if(br.hasErrors())
			throw new ValidateException(br.getFieldErrors());
		Integer medId = medicine.addMedicine(medicineDto);
		
		return new SuccessMessage("Medicine Addded, ID is " + medId);
	}
	
	/**
	 * Method: viewMedicineById
	 * @GetMapping:It is used to handle the HTTP get requests matched with given URI Expression
	 * @Param Integer MedicineId
	 * @PathVariable: extract values from the URI path to method argument
	 * @return medicine instance for the given ID
	 * @throws throws MedicineNotFound exception if the ID is not found
	 * Description: This methods returns Medicine instances .
	 * @CreatedAt: 
	**/
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("viewmedicinebyid/{medicineid}")
	public Medicine viewMedicineById(@PathVariable("medicineid") Integer medicineId) throws MedicineNotFoundException {
		Medicine medicine1 = medicine.getMedicineByMedicineId(medicineId);
		return medicine1;

	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("editmedicine")
	public SuccessMessage editMedicine(@RequestBody @Valid MedicineDto meddto, BindingResult br) throws ValidateException, CategoryNotFoundException, MedicineNotFoundException	{
		if (br.hasErrors())
			throw new ValidateException(br.getFieldErrors());
		medicine.editMedicine(meddto);
		return new SuccessMessage("Medicine edited successfully");
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("deleteMedicine/{medicineId}")
	public SuccessMessage deleteMedicine(@PathVariable ("medicineId") int medicineId) throws MedicineNotFoundException	{
		medicine.deleteMedicine(medicineId);
		System.out.println("inside delete");
		return new SuccessMessage("Medicine deleted successfully");
	}
}
