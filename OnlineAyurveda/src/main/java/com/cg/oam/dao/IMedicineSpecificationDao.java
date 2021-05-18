package com.cg.oam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oam.entities.MedicineSpecifications;
@Repository
public interface IMedicineSpecificationDao extends JpaRepository<MedicineSpecifications, Integer>{
	
}
