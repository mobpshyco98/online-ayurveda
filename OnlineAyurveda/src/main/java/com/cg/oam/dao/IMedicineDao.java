package com.cg.oam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oam.entities.Medicine;

@Repository
public interface IMedicineDao extends JpaRepository<Medicine, Integer> {
	public Medicine findByMedicineId(Integer medicineId);
}
