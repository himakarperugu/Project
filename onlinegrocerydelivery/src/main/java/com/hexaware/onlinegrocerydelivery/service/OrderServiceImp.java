package com.hexaware.onlinegrocerydelivery.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.onlinegrocerydelivery.dto.CartDTO;
import com.hexaware.onlinegrocerydelivery.dto.OrderDTO;
import com.hexaware.onlinegrocerydelivery.entity.Cart;
import com.hexaware.onlinegrocerydelivery.entity.Customer;
import com.hexaware.onlinegrocerydelivery.entity.Orders;
import com.hexaware.onlinegrocerydelivery.entity.Product;
import com.hexaware.onlinegrocerydelivery.exception.AdminNotFoundException;
import com.hexaware.onlinegrocerydelivery.exception.OrderNotFoundException;
import com.hexaware.onlinegrocerydelivery.repository.ICustomerRepository;
import com.hexaware.onlinegrocerydelivery.repository.IOrderRepository;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
//Author:sakitha

@Service
public class OrderServiceImp implements IOrderService {
	
	Logger logger = LoggerFactory.getLogger(OrderServiceImp.class);
	
	
	@Autowired
	private IOrderRepository orderrepository;
	@Autowired
	private ICustomerRepository customerrepository1;
	@Autowired
	private JavaMailSender mailSender;
	@Value("${spring.mail.username}") 
	private String fromMail;
	
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
			Product product=new Product();
			
			orders.setOrderId(orderDTO.getOrderId());
			orders.setCustomer(customer);
			orders.setOrderDate(orderDTO.getOrderDate());
			orders.setDeliveryAddress(orderDTO.getDeliveryAddress());
			orders.setPaymentMethod(orderDTO.getPaymentMethod());
			
			sendMail(customer.getEmail(), orders.getDeliveryAddress(), orders.getPaymentMethod(), orders.getOrderDate(), product.getProductName(),customer.getCustomerName());  
			orderrepository.save(orders);
			
			
			
		
			
			logger.info("Inserted Orders Data Into Table " +orderDTO);
		
	
			return orderrepository.save(orders);
	}

	@Override
	public List<OrderDTO> getByCustomerId(int customerId) {
	    List<Orders> orderList = orderrepository.findOrdersByCustomerId(customerId);
	    List<OrderDTO> orderDTOList = new ArrayList<>();

	    for (Orders orders : orderList) {
	        OrderDTO orderDTO = new OrderDTO();
	        
	        orderDTO.setOrderId(orders.getOrderId());
	        orderDTO.setCustomerId(orders.getCustomer().getCustomerId());
	        orderDTO.setDeliveryAddress(orders.getDeliveryAddress());
	        orderDTO.setOrderDate(orders.getOrderDate());
	        orderDTO.setPaymentMethod(orders.getPaymentMethod());

	        // Add the created OrderDTO to the list
	        orderDTOList.add(orderDTO);
	    }

	    return orderDTOList;
	}

	
	
	
	@Override
	public OrderDTO getById(int orderId) {
		Orders orders = orderrepository.findById(orderId).orElse(new Orders());
		OrderDTO orderDTO = new OrderDTO();
		
		if (orders.getOrderId()==0) {
			throw new OrderNotFoundException(HttpStatus.NOT_FOUND," Orders with Order Id : " + orderId + " Not Found " );

		}
		orderDTO.setOrderId(orders.getOrderId());
		orderDTO.setCustomerId(orders.getCustomer().getCustomerId());
		orderDTO.setDeliveryAddress(orders.getDeliveryAddress());
		orderDTO.setOrderDate(orders.getOrderDate());
		orderDTO.setPaymentMethod(orders.getPaymentMethod());
		
//		orders.setOrderId(orderDTO.getOrderId());
//		orders.setCustomer(customer);
//		orders.setOrderDate(orderDTO.getOrderDate());
//		orders.setDeliveryAddress(orderDTO.getDeliveryAddress());
//		orders.setPaymentMethod(orderDTO.getPaymentMethod());
		
		
		
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
        Orders existingOrder = orderrepository.findById(orderDTO.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException(HttpStatus.NOT_FOUND,
                        "Order with id: " + orderDTO.getOrderId() + " not found"));

//        existingOrder.setCustomerId(orderDTO.getCustomerId());
        existingOrder.setOrderDate(orderDTO.getOrderDate());
        existingOrder.setDeliveryAddress(orderDTO.getDeliveryAddress());
        existingOrder.setPaymentMethod(orderDTO.getPaymentMethod());

        logger.info("Updated Orders Data Into Table: " + existingOrder);

        return orderrepository.save(existingOrder);
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
	public void sendMail(String email,String deliveryAddress, String paymentMethod, LocalDate orderDate, String productName, String customerName) {
		SimpleMailMessage messsage = new SimpleMailMessage();
	messsage.setFrom(fromMail);
	messsage.setSubject("Welcome to GroceryPal : "+ customerName );
	messsage.setText(""+ productName + customerName); 
	messsage.setTo(email);
	mailSender.send(messsage);
	}


}
