package com.cg.TestMedicineSpecifications;

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
import com.cg.oam.exceptions.ValidateException;
import com.cg.oam.service.IMedicineSpecService;
import com.cg.oam.service.MedicineSpecServiceImpl;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class TestAddMedSpecs {
	
	@Mock
	private IMedicineSpecificationDao medSpecsDao;
	
	@Mock
	private IMedicineDao medDao;
	
	@InjectMocks
	IMedicineSpecService medSpecService = new MedicineSpecServiceImpl();
	
	@BeforeEach
	public void beforeEach() {
		Optional<Medicine> optValid = Optional.of(new Medicine());
		Optional<Medicine> optInvalid = Optional.empty();
		when(medDao.findById(101)).thenReturn(optValid);
		when(medDao.findById(110)).thenReturn(optInvalid);
		
		MedicineSpecifications savedMedicine = new MedicineSpecifications();
		savedMedicine.setSpecId(2007);
		when(medSpecsDao.save(any(MedicineSpecifications.class))).thenReturn(savedMedicine);
	}
	
	@Test
	@DisplayName(value = "Add medicine specification test for valid MedicineId and SpecId")
	void testAddMedSpecs() throws MedicineNotFoundException, ValidateException {
		MedicineSpecificationsDto medSpecsDto = new MedicineSpecificationsDto(101, 2007);
		assertNotNull(medSpecService.addSpecs(medSpecsDto));
	
	}
	
	@Test
	@DisplayName(value = "Add medicine specification test for invalid MedicineId")
	void testAddMedSpecsWrongMedId() throws MedicineNotFoundException, ValidateException{
		MedicineSpecificationsDto medSpecsDto = new MedicineSpecificationsDto(109, 2007);
		assertThrows(MedicineNotFoundException.class, () -> medSpecService.addSpecs(medSpecsDto));
	}
	
	
}
