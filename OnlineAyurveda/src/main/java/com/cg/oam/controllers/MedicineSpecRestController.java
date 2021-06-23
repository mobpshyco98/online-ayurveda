package com.cg.oam.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oam.dto.MedicineSpecificationsDto;
import com.cg.oam.dto.SuccessMessage;
import com.cg.oam.entities.MedicineSpecifications;
import com.cg.oam.exceptions.MedicineNotFoundException;
import com.cg.oam.exceptions.NoSpecsException;
import com.cg.oam.exceptions.ValidateException;
import com.cg.oam.service.IMedicineSpecService;
import com.cg.oam.util.MedicineSpecificationConstants;

/**
 * @author - Soumyajit Ghosh
 * @Version - 1.0
 * Description - This controller class contains methods for adding a new medicine specification, viewing a medicine specification by Medicine Id and editing a medicine specification by Medicine Id
 **/

@RestController
public class MedicineSpecRestController {

	@Autowired
	private IMedicineSpecService specService;

	Logger logger = LoggerFactory.getLogger(MedicineSpecRestController.class);
	
	/**
	 * Method: addMedicineSpecs
	 * @Param MedicineSpecificationsDto medSpecsDto, BindingResult br
	 * @return SuccessMessage along with medicineId
	 * @PostMapping: It is used to handle the HTTP Post requests matched with given URI Expression
	 * @RequestBody: Injects the request body that contains JSON to the method argument using HttpMessageConverters
	 * @Valid: It validates the bean and injects the errors in Spring BindingResult instance.
	 * @throws throws MedicineNotFoundException if medicineId is not present and Validate Exception if the values entered in JSON body doesn't match with the validations given in the Dto class
	 * Description: This methods returns a SuccessMessage along with the medicine ID after adding the medicine specifications in the database
	 * @CreatedAt: 20-May-2021
	**/
	
	@CrossOrigin(origins = {"http://localhost:4200"})
	@PostMapping("addspecs")
	public SuccessMessage addMedicineSpecs(@Valid @RequestBody MedicineSpecificationsDto medSpecsDto, BindingResult br)
			throws MedicineNotFoundException, ValidateException {

		logger.info(medSpecsDto.getSpecName());
		if (br.hasErrors())
			throw new ValidateException(br.getFieldErrors());

		Integer obj = specService.addSpecs(medSpecsDto);
		return new SuccessMessage(MedicineSpecificationConstants.MEDICINE_SPEC_ADDED + obj);

	}
	
	/**
	 * Method: getMedicineSpecifications
	 * @Param Integer medicineId
	 * @return Medicine Specifications instance for the given medicineId
	 * @GettMapping: It is used to handle the HTTP Get requests matched with given URI Expression
	 * @PathVariable: It extracts values from the URI path to method argument
	 * @throws throws MedicineNotFoundException if medicineId is not present and NoSpecsException if no specifications are found
	 * Description: This methods returns the medicine specifications instance
	 * @CreatedAt: 20-May-2021
	**/
	
	@CrossOrigin(origins = {"http://localhost:4200"})
	@GetMapping("viewspecs/{med_id}")
	public List<MedicineSpecifications> getMedicineSpecifications(@PathVariable("med_id") Integer medicineId) throws MedicineNotFoundException, NoSpecsException{
		return specService.getMedSpecsById(medicineId);
	}
	
	/**
	 * Method: editMedicineSpecs
	 * @Param MedicineSpecificationsDto medSpecsDto, BindingResult br
	 * @return SuccessMessage along with specificationId
	 * @PutMapping: It is used to handle the HTTP Put requests matched with given URI Expression
	 * @RequestBody: Injects the request body that contains JSON to the method argument using HttpMessageConverters
	 * @Valid: It validates the bean and injects the errors in Spring BindingResult instance.
	 * @throws throws MedicineNotFoundException if medicineId is not present, NoSpecsException if no specifications are found and Validate Exception if the values entered in JSON body doesn't match with the validations given in the Dto class
	 * Description: This methods returns a SuccessMessage along with the specification ID after editing the medicine specifications in the database
	 * @CreatedAt: 20-May-2021
	**/
	
	@CrossOrigin(origins = {"http://localhost:4200"})
	@PutMapping("editspecs")
	public SuccessMessage editMedicineSpecs(@Valid @RequestBody MedicineSpecificationsDto medSpecsDto, BindingResult br) throws MedicineNotFoundException, NoSpecsException, ValidateException{
		
		if(br.hasErrors())
			throw new ValidateException(br.getFieldErrors());
		
		specService.editSpecs(medSpecsDto);
		return new SuccessMessage(MedicineSpecificationConstants.SPEC_EDIT_SUCCESSFUL + medSpecsDto.getSpecId());
	}
	
	
}
