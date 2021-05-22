package com.cg.TestMedicineSpecifications;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oam.dao.IMedicineDao;
import com.cg.oam.dao.IMedicineSpecificationDao;
import com.cg.oam.entities.Medicine;
import com.cg.oam.entities.MedicineSpecifications;
import com.cg.oam.exceptions.CustomerNotFoundException;
import com.cg.oam.exceptions.MedicineNotFoundException;
import com.cg.oam.exceptions.NoSpecsException;
import com.cg.oam.service.IMedicineSpecService;
import com.cg.oam.service.MedicineSpecServiceImpl;

@SpringBootTest
public class TestViewByMedicineId {

	@Mock
	private IMedicineDao medDao;

	@Mock
	private IMedicineSpecificationDao medSpecDao;

	@InjectMocks
	IMedicineSpecService medSpecService = new MedicineSpecServiceImpl();

	@BeforeEach
	void BeforeEach() {
		Optional<Medicine> optValid = Optional.of(new Medicine());
		Optional<Medicine> optInvalid = Optional.empty();

		List<MedicineSpecifications> lst = new ArrayList<>();
		lst.add(new MedicineSpecifications("exampleSpecName", "exampleSpecValue"));
		lst.add(new MedicineSpecifications("exampleName", "exampleValue"));

		List<MedicineSpecifications> lst1 = new ArrayList<>();

		when(medDao.findById(101)).thenReturn(optValid);
		when(medDao.findById(110)).thenReturn(optInvalid);

		when(medSpecDao.getSpecifications(101)).thenReturn(lst);
		when(medSpecDao.getSpecifications(110)).thenReturn(lst1);
	}

	
	@Test
	@DisplayName(value = "Test view medicine specifications  for valid MedicineId: 101")
	public void testViewByMedicineId() throws CustomerNotFoundException, MedicineNotFoundException, NoSpecsException {
		assertTrue(medSpecService.getMedSpecsById(101).size() > 0);
	}
	
	@Test
	@DisplayName(value = "Test view medicine specifications for invalid MedicineID: 550")
	public void testViewByMedicineIdInValid() {
		assertThrows(MedicineNotFoundException.class, () -> medSpecService.getMedSpecsById(550));
	}

}
