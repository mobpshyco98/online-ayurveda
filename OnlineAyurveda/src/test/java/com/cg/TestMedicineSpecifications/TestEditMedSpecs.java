package com.cg.TestMedicineSpecifications;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oam.dao.IMedicineDao;
import com.cg.oam.dao.IMedicineSpecificationDao;
import com.cg.oam.dto.MedicineSpecificationsDto;
import com.cg.oam.entities.Medicine;
import com.cg.oam.entities.MedicineSpecifications;
import com.cg.oam.exceptions.MedicineNotFoundException;
import com.cg.oam.exceptions.NoSpecsException;
import com.cg.oam.exceptions.ValidateException;
import com.cg.oam.service.IMedicineSpecService;
import com.cg.oam.service.MedicineSpecServiceImpl;

@SpringBootTest
public class TestEditMedSpecs {
	@Mock
	private IMedicineDao medDao;

	@Mock
	private IMedicineSpecificationDao medSpecsDao;
	
	@InjectMocks
	IMedicineSpecService medSpecService = new MedicineSpecServiceImpl();
	
	@BeforeEach
	public void BeforeEach(){
		Optional<Medicine> optValid = Optional.of(new Medicine());
		Optional<Medicine> optInvalid = Optional.empty();
		
		Optional<MedicineSpecifications> medSpecsOpt1 = Optional.of(new MedicineSpecifications());
		Optional<MedicineSpecifications> medSpecsOpt2 = Optional.empty();
		
		when(medSpecsDao.findById(1001)).thenReturn(medSpecsOpt1);
		when(medSpecsDao.findById(1101)).thenReturn(medSpecsOpt2);
		
		when(medDao.findById(101)).thenReturn(optValid);
		when(medDao.findById(110)).thenReturn(optInvalid);
		
		MedicineSpecifications savedMedicine = new MedicineSpecifications();
		when(medSpecsDao.save(any(MedicineSpecifications.class))).thenReturn(savedMedicine);

	}
	
	@Test
	@DisplayName(value = "Test edit medicine specifications for valid MedicineId: 101 and SpecificationId: 1001")
	void testEditMedSpecs() throws MedicineNotFoundException, NoSpecsException, ValidateException {
		MedicineSpecificationsDto medSpecsDto = new MedicineSpecificationsDto();
		medSpecsDto.setMedicineId(101);
		medSpecsDto.setSpecId(1001);
		assertTrue(medSpecService.editSpecs(medSpecsDto));
	
	}
	
	@Test
	@DisplayName(value = "Test edit medicine specifications for invalid MedicineId: 110 and valid SpecificationId: 1001")
	void testEditMedSpecsInvalidMedId(){
		MedicineSpecificationsDto medSpecsDto = new MedicineSpecificationsDto();
		medSpecsDto.setMedicineId(110);
		medSpecsDto.setSpecId(1001);
		assertThrows(MedicineNotFoundException.class, () -> medSpecService.editSpecs(medSpecsDto));
	
	}
	
	@Test
	@DisplayName(value = "Test edit medicine specifications for valid MedicineId: 101 and invalid SpecificationId: 1101")
	void testEditMedSpecsInvalidSpecId(){
		MedicineSpecificationsDto medSpecsDto = new MedicineSpecificationsDto();
		medSpecsDto.setMedicineId(101);
		medSpecsDto.setSpecId(1101);
		assertThrows(NoSpecsException.class, () -> medSpecService.editSpecs(medSpecsDto));
	
	}
}
