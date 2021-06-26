package com.cg.oam.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.oam.entities.OrderMedicine;

@Repository
public interface IOrderMedicineDao extends JpaRepository<OrderMedicine, Integer>{
	// custom query
		@Query("from OrderMedicine o inner join fetch o.customer_order c where c.customerId=:custid ")
		public List<OrderMedicine> viewOrderByCustId(@Param("custid") Integer custId);
		
		//@Query("from OrderMedicine o where o.orderId=:ordid ")
		//public Optional<OrderMedicine> findById(@Param("ordid")Integer orderId);
}
