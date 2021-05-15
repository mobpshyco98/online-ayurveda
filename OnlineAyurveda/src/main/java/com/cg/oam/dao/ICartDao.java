package com.cg.oam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.oam.entities.Cart;

public interface ICartDao extends JpaRepository<Cart, Integer>{

}
