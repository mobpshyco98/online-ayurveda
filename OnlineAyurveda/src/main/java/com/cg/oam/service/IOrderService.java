package com.cg.oam.service;

import org.springframework.stereotype.Service;

import com.cg.oam.exceptions.OrderIdInvalidException;

@Service
public interface IOrderService {
	
	public boolean removeItemsByOrderId(Integer orderId) throws OrderIdInvalidException;
}
