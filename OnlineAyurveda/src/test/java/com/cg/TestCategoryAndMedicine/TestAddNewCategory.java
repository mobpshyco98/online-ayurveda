package com.cg.TestCategoryAndMedicine;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oam.dao.ICategoryDao;
import com.cg.oam.dto.CategoryDto;
import com.cg.oam.entities.Category;
import com.cg.oam.service.CategoryServiceImpl;
import com.cg.oam.service.ICategoryService;

@SpringBootTest
public class TestAddNewCategory {

	@Mock
	private ICategoryDao catdao;

	@InjectMocks
	ICategoryService catService = new CategoryServiceImpl();

	@BeforeEach
	public void beforeEach() {
		Category cat = new Category();
		cat.setCategoryId(101);
		cat.setCategoryName("xyz");
		when(catdao.save(any(Category.class))).thenReturn(cat);
	}

	@Test
	@DisplayName(value = "test for adding category")
	public void test1() {
		CategoryDto cat = new CategoryDto(101, "xyz");
		assertTrue(catService.addCategory(cat) == 101);
	}
}
