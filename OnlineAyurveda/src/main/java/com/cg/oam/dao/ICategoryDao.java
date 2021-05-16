package com.cg.oam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.oam.entities.Category;

public interface ICategoryDao extends JpaRepository<Category, Integer>{

}
