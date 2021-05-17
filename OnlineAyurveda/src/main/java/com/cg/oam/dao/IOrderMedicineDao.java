package com.cg.oam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oam.entities.OrderMedicine;

@Repository
public interface IOrderMedicineDao extends JpaRepository<OrderMedicine, Integer>{

}
