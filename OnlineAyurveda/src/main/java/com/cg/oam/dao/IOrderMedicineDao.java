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
		@Query("from OrderMedicine o inner join fetch o.customer c where c.customerId=:custid ")
		public List<OrderMedicine> viewOrderByUserId(@Param("custid") Integer custId);

		public Optional<OrderMedicine> findById(Integer orderId);
}
