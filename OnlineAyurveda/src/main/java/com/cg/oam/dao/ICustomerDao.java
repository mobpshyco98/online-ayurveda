package com.cg.oam.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.oam.entities.Customer;

@Repository
public interface ICustomerDao extends JpaRepository<Customer, Integer> {
	@Query("from Customer c where c.customerId = :custId")
	public Customer viewByCustomerId(@Param("custId") Integer customerId);
	
	@Query("from Customer c where c.customerId = :custId")
	public Optional<Customer> viewByCustomerId1(@Param("custId") Integer customerId);
	
	@Query("from Customer c where c.contactNo = :contactno")
	public Optional<Customer> viewCustomer(@Param("contactno") String contactNo);
}
