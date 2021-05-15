package com.cg.oam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.oam.entities.OrderMedicine;

public interface IOrderMedDao extends JpaRepository<OrderMedicine, Integer>{

}
