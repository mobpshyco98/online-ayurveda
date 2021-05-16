package com.cg.oam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oam.entities.Customer;

@Repository
public interface ICustomerDao extends JpaRepository<Customer, Integer> {
	public Customer findByCustomerId(Integer customerId);
}
