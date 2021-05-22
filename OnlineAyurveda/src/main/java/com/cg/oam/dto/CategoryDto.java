package com.cg.oam.dto;

import java.util.Set;

import com.cg.oam.entities.Medicine;


public class CategoryDto {

	
	public CategoryDto(Integer categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	private Integer categoryId;


	private String categoryName;

	
	private Set<Medicine> meds;

	public Set<Medicine> getMeds() {
		return meds;
	}

	public void setMeds(Set<Medicine> meds) {
		this.meds = meds;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
    
	public CategoryDto() {
		
	}
	
	public CategoryDto(String categoryName, Set<Medicine> meds) {
		super();
		this.categoryName = categoryName;
		this.meds = meds;
	}

//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return categoryName + " " + categoryId;
//	}

}