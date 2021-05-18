package com.cg.oam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.oam.entities.MedicineSpecifications;
@Repository
public interface IMedicineSpecificationDao extends JpaRepository<MedicineSpecifications, Integer>{
	
	@Query("from MedicineSpecifications ms inner join fetch ms.medicine m where m.medicineId=:med_id")
	public List<MedicineSpecifications> getSpecifications(@Param("med_id") Integer medicineId);
}
