package com.cg.oam.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oam.dao.IOrderMedicineDao;
import com.cg.oam.entities.OrderMedicine;
import com.cg.oam.exceptions.OrderIdInvalidException;
import com.cg.oam.util.OrderMedicineConstants;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderMedicineDao orderMedDao;

	@Override
	@Transactional
	public boolean removeItemsByOrderId(Integer orderId) throws OrderIdInvalidException {
		Optional<OrderMedicine> obj = orderMedDao.findById(orderId);
		if (!obj.isPresent())
			throw new OrderIdInvalidException(OrderMedicineConstants.ORDER_ID_INVALID);
		orderMedDao.delete(obj.get());
		return true;
	}

}
