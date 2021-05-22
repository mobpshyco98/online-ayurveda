package com.cg.TestCategoryAndMedicine;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oam.dao.IMedicineDao;
import com.cg.oam.entities.Medicine;
import com.cg.oam.exceptions.MedicineNotFoundException;
import com.cg.oam.service.IMedicineService;
import com.cg.oam.service.MedicineServiceImpl;

import static org.mockito.Mockito.when;

@SpringBootTest
public class TestViewMedicineByID {

	@Mock
	private IMedicineDao meds;

	@InjectMocks
	IMedicineService service = new MedicineServiceImpl();

	@BeforeEach
	public void beforeEach() {
		Optional<Medicine> opt1 = Optional.of(new Medicine());
		Optional<Medicine> opt2 = Optional.empty();

		when(meds.findById(1001)).thenReturn(opt1);
		when(meds.findById(4567)).thenReturn(opt2);
	}

	@Test
	@DisplayName(value = "test for meddcineid 1001")
	public void testviewmedicinebyid1() throws MedicineNotFoundException {
		assertNotNull(service.getMedicineByMedicineId(1001));
	}

	@Test
	@DisplayName(value = "test for meddcineid 4567")
	public void testviewmedicinebyid2() {
		assertThrows(MedicineNotFoundException.class, () -> service.getMedicineByMedicineId(4567));
	}
}
