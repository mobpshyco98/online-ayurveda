package com.cg.oam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.oam.entities.Cart;

@Repository
public interface ICartDao extends JpaRepository<Cart, Integer> {
	@Query("from Cart a inner join a.cust b inner join a.medicine where b.customerId = :custId")
	public List<Cart> viewByCustId(@Param("custId") Integer custId);
}
