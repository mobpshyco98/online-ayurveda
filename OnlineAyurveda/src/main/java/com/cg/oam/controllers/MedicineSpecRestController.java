package com.cg.oam.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oam.dto.MedicineSpecificationsDto;
import com.cg.oam.dto.SuccessMessage;
import com.cg.oam.exceptions.MedicineNotFoundException;
import com.cg.oam.exceptions.ValidateException;
import com.cg.oam.service.IMedicineSpecService;

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
		return new SuccessMessage("Medicine Specification Added" + obj);

	}
}
