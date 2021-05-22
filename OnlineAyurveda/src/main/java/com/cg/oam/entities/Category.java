package com.cg.oam.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cg_category")
public class Category {

	@Id
	@Column(name = "category_id")
	@SequenceGenerator(name = "seq1", sequenceName = "cart_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
	private Integer categoryId;

	@Column(name = "category_name")
	private String categoryName;

	@OneToMany(mappedBy = "category")
	@JsonIgnore
	private Set<Medicine> meds;

	public Set<Medicine> getMeds() {
		return meds;
	}

	public Category(Integer categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public Category(Integer categoryId, String categoryName, Set<Medicine> meds) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.meds = meds;
	}

	public Category() {
		super();
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return categoryName + " " + categoryId;
	}

}