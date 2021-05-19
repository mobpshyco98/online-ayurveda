package com.cg.oam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.oam.entities.Category;
import com.cg.oam.exceptions.CategoryNameNotFoundException;

@Repository
public interface ICategoryDao extends JpaRepository<Category, Integer> {
	@Query("from Category c where c.categoryName = :categoryname")
	public Category getCategoryIdByName(@Param("categoryname") String categoryName);
}
