package com.cg.oam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.oam.entities.Medicine;

public interface IMedicineDao extends JpaRepository<Medicine, Integer>{

}
