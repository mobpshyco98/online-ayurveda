package com.cg.oam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.oam.entities.Category;

public interface ICatDao extends JpaRepository<Category, Integer>{

}
