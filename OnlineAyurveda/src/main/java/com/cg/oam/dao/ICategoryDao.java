package com.cg.oam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oam.entities.Category;

@Repository
public interface ICategoryDao extends JpaRepository<Category, Integer>{

}
