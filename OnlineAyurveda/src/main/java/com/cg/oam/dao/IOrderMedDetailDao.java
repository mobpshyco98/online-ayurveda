package com.cg.oam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.oam.entities.OrderMedicineDetails;

public interface IOrderMedDetailDao extends JpaRepository<OrderMedicineDetails, Integer>{

}
