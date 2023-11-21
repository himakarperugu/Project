package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.onlinegrocerydelivery.dto.OrderDTO;
import com.hexaware.onlinegrocerydelivery.entity.Customer;
import com.hexaware.onlinegrocerydelivery.entity.Orders;
import com.hexaware.onlinegrocerydelivery.exception.AdminNotFoundException;
import com.hexaware.onlinegrocerydelivery.exception.OrderNotFoundException;
import com.hexaware.onlinegrocerydelivery.repository.ICustomerRepository;
import com.hexaware.onlinegrocerydelivery.repository.IOrderRepository;
//Author:sakitha

@Service
public class OrderServiceImp implements IOrderService {
	
	Logger logger = LoggerFactory.getLogger(OrderServiceImp.class);
	
	
	@Autowired
	private IOrderRepository orderrepository;
	@Autowired
	private ICustomerRepository customerrepository1;
	
	public IOrderRepository getOrderrepository() {
		return orderrepository;
	}

	public void setOrderrepository(IOrderRepository orderrepository) {
		this.orderrepository = orderrepository;
	}
	public ICustomerRepository getCustomerrepository() {
		return customerrepository1;
	}

	public void setCustomerrepository(ICustomerRepository customerrepository1) {
		this.customerrepository1 = customerrepository1;
	}
	

	@Override
	public Orders addOrder(OrderDTO orderDTO) {
			
			Orders orders =new Orders();
			Customer customer=customerrepository1.findById(orderDTO.getCustomerId()).orElse(null);
					
			
			orders.setOrderId(orderDTO.getOrderId());
			orders.setCustomerId(orderDTO.getCustomerId());
			orders.setOrderDate(orderDTO.getOrderDate());
			orders.setDeliveryAddress(orderDTO.getDeliveryAddress());
			orders.setPaymentMethod(orderDTO.getPaymentMethod());
			orders.setTotalAmount(orderDTO.getTotalAmount());
			orders.setCustomer(customer);
			
		
			
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
	    Orders orders = orderrepository.findById(orderId).orElse(null);

	    if (orders != null) {
	        orderrepository.deleteById(orders.getOrderId());
	        logger.info("Deleting the Orders Record Using Orders ID " + orderId);
	    } else {
	        logger.warn("Orders with Order ID " + orderId + " not found. No Deletion Operation is performed.");
	    }
	}


}
