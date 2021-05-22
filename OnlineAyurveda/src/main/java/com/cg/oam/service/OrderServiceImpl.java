package com.cg.oam.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oam.dao.IOrderMedicineDao;
import com.cg.oam.entities.OrderMedicine;
import com.cg.oam.exceptions.OrderIdInvalidException;
import com.cg.oam.util.OrderMedicineConstants;

/**
 * @author - Soumyajit Ghosh
 * @Version - 1.0
 * Description - This service class contains methods for canceling an order by orderId
 **/

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderMedicineDao orderMedDao;
	
	/**
	 * Method: removeItemsByOrderId
	 * @Override: It is used to override the JpaRepository methods for performing CRUD operations. 
	 * @Transactional: Transaction environment is provided by the transaction manager for the method.
	 * @Param Integer orderId
	 * @return Boolean value i.e., true
	 * @Throws throws OrderIdInvalidException if the order Id is not found
	 * Description: This methods cancel an order using orderId
	 * CreatedAt: 20-May-2021
	**/
	
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
