package com.cg.oam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oam.entities.OrderMedicineDetails;

@Repository
public interface IOrderMedicineDetailDao extends JpaRepository<OrderMedicineDetails, Integer>{

}
