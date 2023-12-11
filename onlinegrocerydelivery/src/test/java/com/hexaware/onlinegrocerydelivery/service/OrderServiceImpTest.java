package com.hexaware.onlinegrocerydelivery.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hexaware.onlinegrocerydelivery.dto.OrderDTO;
import com.hexaware.onlinegrocerydelivery.entity.Orders;
//Author:sakitha

class OrderServiceImpTest {

	@Test
	void testAddOrder() {
		Orders orders =new Orders();
		orders.setOrderId(4001);
//		orders.setCustomerId(2001);
		orders.setDeliveryAddress("Ongole");
		orders.setPaymentMethod("COD");

		assertEquals(4001, orders.getOrderId());
	}

	@Test
	void testGetById() {
		OrderDTO orderDTO = new OrderDTO();	
		orderDTO.setOrderId(4001);
		orderDTO.setCustomerId(2001);
		orderDTO.setDeliveryAddress("Ongole");
		orderDTO.setPaymentMethod("COD");
		assertEquals(4001, orderDTO.getOrderId());}

	@Test
	void testGetAllOrder() {
		OrderDTO orderDTO = new OrderDTO();	
		orderDTO.setOrderId(4001);
		orderDTO.setCustomerId(2001);
		orderDTO.setDeliveryAddress("Ongole");
		orderDTO.setPaymentMethod("COD");
	}

	@Test
	void testUpdateOrder() {
		Orders orders =new Orders();
		orders.setOrderId(4001);
//		orders.setCustomerId(2001);
		orders.setDeliveryAddress("Ongole");
		orders.setPaymentMethod("COD");
	}

	@Test
	void testDeleteById() {
		
	}

}
