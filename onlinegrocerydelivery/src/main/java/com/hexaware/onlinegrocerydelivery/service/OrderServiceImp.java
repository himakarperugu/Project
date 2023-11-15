package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.onlinegrocerydelivery.dto.OrderDTO;
import com.hexaware.onlinegrocerydelivery.entity.Orders;
import com.hexaware.onlinegrocerydelivery.repository.OrderRepository;

@Service
public class OrderServiceImp implements IOrderService {
	
	
	private OrderRepository orderrepository;
	
	
	@Autowired
	public OrderServiceImp(OrderRepository orderrepository) {
		super();
		this.orderrepository = orderrepository;
	}

	@Override
	public Orders addOrder(OrderDTO orderDTO) {
			
			Orders orders =new Orders();
			
			
			orders.setOrderId(orderDTO.getOrderId());
			orders.setCustomerId(orderDTO.getCustomerId());
			orders.setOrderDate(orderDTO.getOrderDate());
			orders.setDeliveryAddress(orderDTO.getDeliveryAddress());
			orders.setPaymentMethod(orderDTO.getPaymentMethod());
			orders.setTotalAmount(orderDTO.getTotalAmount());
	
			return orderrepository.save(orders);
	}

	@Override
	public OrderDTO getById(int orderId) {
		Orders orders = orderrepository.findById(orderId).orElse(null);
		OrderDTO orderDTO = new OrderDTO();
		orders.setOrderId(orderDTO.getOrderId());
		orders.setCustomerId(orderDTO.getCustomerId());
		orders.setOrderDate(orderDTO.getOrderDate());
		orders.setDeliveryAddress(orderDTO.getDeliveryAddress());
		orders.setPaymentMethod(orderDTO.getPaymentMethod());
		orders.setTotalAmount(orderDTO.getTotalAmount());

		
		return orderDTO;
	}

	@Override
	public List<Orders> getAllOrder() {
		
		return orderrepository.findAll();
	}

	@Override
	public Orders updateOrder(OrderDTO orderDTO) {
	
		Orders orders = new Orders();
		orders.setOrderId(orderDTO.getOrderId());
		orders.setCustomerId(orderDTO.getCustomerId());
		orders.setOrderDate(orderDTO.getOrderDate());
		orders.setDeliveryAddress(orderDTO.getDeliveryAddress());
		orders.setPaymentMethod(orderDTO.getPaymentMethod());
		orders.setTotalAmount(orderDTO.getTotalAmount());

		
		
		
		return orderrepository.save(orders);
		
	}

	@Override
	public void deleteById(int orderId) {
		Orders orders=orderrepository.findById(orderId).orElse(null);
		orderrepository.deleteById(orders.getOrderId());

	}

}
