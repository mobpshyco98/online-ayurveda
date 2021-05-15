package com.cg.oam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.oam.entities.Customer;

public interface ICustDao extends JpaRepository<Customer, Integer> {

}
