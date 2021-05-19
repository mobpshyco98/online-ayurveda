package com.cg.oam.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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

@RestController
public class MedicineSpecRestController {

	@Autowired
	private IMedicineSpecService specService;

	Logger logger = LoggerFactory.getLogger(MedicineSpecRestController.class);

	@PostMapping("addspecs")
	public SuccessMessage addMedicineSpecs(@Valid @RequestBody MedicineSpecificationsDto medSpecsDto, BindingResult br)
			throws MedicineNotFoundException, ValidateException {

		logger.info(medSpecsDto.getSpecName());
		if (br.hasErrors())
			throw new ValidateException(br.getFieldErrors());

		Integer obj = specService.addSpecs(medSpecsDto);
		return new SuccessMessage(MedicineSpecificationConstants.MEDICINE_SPEC_ADDED + obj);

	}
	
	@GetMapping("viewspecs/{med_id}")
	public List<MedicineSpecifications> getMedicineSpecifications(@PathVariable("med_id") Integer medicineId) throws MedicineNotFoundException, NoSpecsException{
		logger.info(medicineId + "");
		return specService.getMedSpecsById(medicineId);
	}
	
	@PutMapping("editspecs")
	public SuccessMessage editMedicineSpecs(@RequestBody MedicineSpecificationsDto medSpecsDto, BindingResult br) throws MedicineNotFoundException, NoSpecsException, ValidateException{
		
		if(br.hasErrors())
			throw new ValidateException(br.getFieldErrors());
		
		specService.editSpecs(medSpecsDto);
		return new SuccessMessage(MedicineSpecificationConstants.SPEC_EDIT_SUCCESSFUL + medSpecsDto.getSpecId());
	}
	
	
}
