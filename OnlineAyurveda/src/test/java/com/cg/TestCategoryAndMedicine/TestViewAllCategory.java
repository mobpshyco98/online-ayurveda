package com.cg.TestCategoryAndMedicine;

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
import com.cg.oam.entities.Category;
import com.cg.oam.exceptions.CategoryNotFoundException;
import com.cg.oam.service.CategoryServiceImpl;
import com.cg.oam.service.ICategoryService;

@SpringBootTest
public class TestViewAllCategory {

	@Mock
	private ICategoryDao catdao;

	@InjectMocks
	ICategoryService catservice = new CategoryServiceImpl();

	@BeforeEach
	public void beforeEach() {
		List<Category> lst = new ArrayList<>();
		lst.add(new Category());
		lst.add(new Category());
		when(catdao.findAll()).thenReturn(lst);
	}

	@Test
	@DisplayName(value = "test for view all category")
	public void test1() throws CategoryNotFoundException {
		assertTrue(catservice.viewAllCategory().size() > 0);
	}

}
