package com.cg.oam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.oam.entities.Medicine;

@Repository
public interface IMedicineDao extends JpaRepository<Medicine, Integer> {
	public Medicine findByMedicineId(Integer medicineId);

	@Query("from Medicine m inner join m.category c where c.categoryName = :categoryName")
	public List<Medicine> medicineByCategoryName(@Param("categoryName") String categoryName);
}
