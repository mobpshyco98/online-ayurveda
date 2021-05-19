package com.cg.oam.service;
import java.util.List;

import com.cg.oam.dto.CategoryDto;
import com.cg.oam.entities.Category;
import com.cg.oam.exceptions.CategoryNotFoundException;

public interface ICategoryService {
	public Integer addCategory(CategoryDto categorydto);
	public List<Category> viewAllCategory() throws CategoryNotFoundException;


}
