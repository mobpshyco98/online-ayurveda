package com.cg.oam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.oam.entities.OrderMedicineDetails;

@Repository
public interface IOrderMedicineDetailDao extends JpaRepository<OrderMedicineDetails, Integer>{
	@Query("from OrderMedicineDetails op inner join fetch op.medOrders po inner join fetch op.medicine where po.orderId=:orderId")
	public List<OrderMedicineDetails> getMedicineDetailsInOrder(@Param("orderId") Integer orderId);
}
