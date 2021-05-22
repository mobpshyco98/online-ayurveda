package com.cg.TestCategoryAndMedicine;


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

import com.cg.oam.dao.ICategoryDao;
import com.cg.oam.dao.IMedicineDao;
import com.cg.oam.dto.MedicineDto;
import com.cg.oam.entities.Category;
import com.cg.oam.entities.Medicine;
import com.cg.oam.exceptions.CategoryNotFoundException;
import com.cg.oam.service.IMedicineService;
import com.cg.oam.service.MedicineServiceImpl;

@SpringBootTest
public class TestAddMedicineForCategory {

	@Mock
	private ICategoryDao catdao;

	@Mock
	private IMedicineDao meds;

	@InjectMocks
	private IMedicineService service = new MedicineServiceImpl();

	@BeforeEach
	public void beforeEach() {

		Optional<Category> opt1 = Optional.of(new Category());
		Optional<Category> opt2 = Optional.empty();

		when(catdao.findById(102)).thenReturn(opt1);
		when(catdao.findById(108)).thenReturn(opt2);

		Medicine medicine = new Medicine();

		medicine.setMedicineId(1001);
		when(meds.save(any(Medicine.class))).thenReturn(medicine);
	}
	
	@Test
	@DisplayName(value = "test for category id 102") 
	public void testforcategoryid1() throws CategoryNotFoundException{
		MedicineDto meddto = new MedicineDto();
		meddto.setMedicineId(1001);
		meddto.setCategoryId(102);
		assertTrue(service.addMedicine(meddto)==1001);
	}
	
	@Test
	@DisplayName(value = "test for category id 108")
	public void testforcategoryid2() throws CategoryNotFoundException{
		MedicineDto meddto = new MedicineDto();
		meddto.setMedicineId(1002);
		meddto.setCategoryId(108);
		assertThrows(CategoryNotFoundException.class, () -> service.addMedicine(meddto));

	
}
}
