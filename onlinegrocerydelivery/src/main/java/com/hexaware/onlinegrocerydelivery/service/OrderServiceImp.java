package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.onlinegrocerydelivery.dto.OrderDTO;
import com.hexaware.onlinegrocerydelivery.entity.Orders;
import com.hexaware.onlinegrocerydelivery.exception.AdminNotFoundException;
import com.hexaware.onlinegrocerydelivery.exception.OrderNotFoundException;
import com.hexaware.onlinegrocerydelivery.repository.OrderRepository;

@Service
public class OrderServiceImp implements IOrderService {
	
	Logger logger = LoggerFactory.getLogger(OrderServiceImp.class);

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
			
		
			
			logger.info("Inserted Orders Data Into Table " +orderDTO);
		
	
			return orderrepository.save(orders);
	}

	@Override
	public OrderDTO getById(int orderId) {
		Orders orders = orderrepository.findById(orderId).orElse(new Orders());
		OrderDTO orderDTO = new OrderDTO();
		
		if (orders.getOrderId()==0) {
			throw new OrderNotFoundException(HttpStatus.NOT_FOUND," Orders with Order Id : " + orderId + " Not Found " );

		}
		
		orders.setOrderId(orderDTO.getOrderId());
		orders.setCustomerId(orderDTO.getCustomerId());
		orders.setOrderDate(orderDTO.getOrderDate());
		orders.setDeliveryAddress(orderDTO.getDeliveryAddress());
		orders.setPaymentMethod(orderDTO.getPaymentMethod());
		orders.setTotalAmount(orderDTO.getTotalAmount());
		logger.info("Fetched Orders Data Using Orders ID " + orderId);

		
		return orderDTO;
	}

	@Override
	public List<Orders> getAllOrder() {
		
		
		logger.info(" Fetched All The Orders Data ");
		
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
		logger.info("  Updated Orders Data Into Table " + orderDTO);

		
		
		
		return orderrepository.save(orders);
		
	}

	@Override
	public void deleteById(int orderId) {
		Orders orders=orderrepository.findById(orderId).orElse(null);
		orderrepository.deleteById(orders.getOrderId());
		logger.info(" Deleting the Orders Record Using Orders ID "+orderId);
		

	}

}
