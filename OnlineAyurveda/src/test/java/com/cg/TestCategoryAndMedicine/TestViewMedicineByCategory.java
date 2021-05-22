package com.cg.TestCategoryAndMedicine;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oam.dao.ICategoryDao;
import com.cg.oam.dao.IMedicineDao;
import com.cg.oam.entities.Medicine;
import com.cg.oam.exceptions.MedicineNotFoundException;
import com.cg.oam.service.IMedicineService;
import com.cg.oam.service.MedicineServiceImpl;

@SpringBootTest
public class TestViewMedicineByCategory {

	@Mock
	private ICategoryDao catdao;

	@Mock
	private IMedicineDao meds;

	@InjectMocks
	IMedicineService service = new MedicineServiceImpl();

	@BeforeEach
	public void beforeEach() {
		List<Medicine> lst = new ArrayList<>();
		lst.add(new Medicine());
		lst.add(new Medicine());
		List<Medicine> lst1 = new ArrayList<>();

		when(meds.medicineByCategoryName("bcd")).thenReturn(lst);
		when(meds.medicineByCategoryName("Ifg")).thenReturn(lst1);

	}

	@Test
	@DisplayName(value = "test for categoryname bcd")
	public void testviewmedicinebycategory1() throws MedicineNotFoundException {
		assertTrue(service.getMedicineByCategoryName("bcd").size() > 0);
	}

	@Test
	@DisplayName(value = "test for categoryname Ifg")
	public void testviewmedicinebycategory2() throws MedicineNotFoundException {
		assertThrows(MedicineNotFoundException.class, () -> service.getMedicineByCategoryName("Ifg"));
	}

}
