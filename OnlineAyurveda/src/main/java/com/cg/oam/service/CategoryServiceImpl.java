package com.cg.oam.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oam.dao.ICategoryDao;
import com.cg.oam.dto.CategoryDto;
import com.cg.oam.entities.Category;

/**
 * @author Arghya Sengupta
 * @Version 
 * Description - This service class contains the methods for adding a new category, view all category
 */
@Service
@Transactional

public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryDao categoryDao;//repository object(autowired)
	
	Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	/**
	 * Method: addCategory
	 * @Override: It is used to override the JpaRepository methods for performing CRUD operations. 
	 * @Param CategoryDto catDto
	 * @return Integer value i.e., category ID
	 * Description: This methods returns the category ID after adding the category instances in the database.
	 * @CreatedAt: 
	**/
	@Override
	public Integer addCategory(CategoryDto categorydto) {
		Category category = new Category();
		category.setCategoryName(categorydto.getCategoryName());
		
		Category newCategory = categoryDao.save(category);
		
		return newCategory.getCategoryId();

	}
	
	/**
	 * Method: viewCategory
	 * @Override: It is used to override the JpaRepository methods for performing CRUD operations.
	 * @Param CategoryDto catDto
	 * @return string
	 * Description: This methods returns the list of category instances from the database
	 * @CreatedAt:
	 **/

	@Override
	public List<Category> viewAllCategory() {
		List<Category> categoryList = categoryDao.findAll();

		return categoryList;
	}

}
