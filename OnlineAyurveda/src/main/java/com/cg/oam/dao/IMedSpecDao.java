package com.cg.oam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.oam.entities.MedicineSpecifications;

public interface IMedSpecDao extends JpaRepository<MedicineSpecifications, Integer>{

}
