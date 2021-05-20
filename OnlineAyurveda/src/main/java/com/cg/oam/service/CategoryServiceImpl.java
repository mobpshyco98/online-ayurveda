package com.cg.oam.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oam.dao.ICategoryDao;
import com.cg.oam.dto.CategoryDto;
import com.cg.oam.entities.Category;

@Service
@Transactional

public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryDao categoryDao;

	@Override
	public Integer addCategory(CategoryDto categorydto) {
		Category category = new Category();
		category.setCategoryName(categorydto.getCategoryName());
		Category newCategory = categoryDao.save(category);
		return newCategory.getCategoryId();

	}

	@Override
	public List<Category> viewAllCategory() {
		List<Category> categoryList = categoryDao.findAll();

		return categoryList;
	}

}
