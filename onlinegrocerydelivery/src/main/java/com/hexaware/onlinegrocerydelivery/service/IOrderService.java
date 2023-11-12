package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;

import com.hexaware.onlinegrocerydelivery.dto.OrderDTO;
import com.hexaware.onlinegrocerydelivery.entity.Orders;

public interface IOrderService {
	
	
	public Orders addOrder(OrderDTO orderDTO);
	
	public OrderDTO getById(int orderId);
	
	public List<Orders> getAllOrder();
	
	Orders updateOrder(OrderDTO orderDTO);
	
	void deleteById(int orderId);

	


}
