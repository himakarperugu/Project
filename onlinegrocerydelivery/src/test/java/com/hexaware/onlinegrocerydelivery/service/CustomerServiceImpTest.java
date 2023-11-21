package com.hexaware.onlinegrocerydelivery.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hexaware.onlinegrocerydelivery.dto.CustomerDTO;
import com.hexaware.onlinegrocerydelivery.entity.Customer;
//Author:Himakar

class CustomerServiceImpTest {

	@Test
	void testAddCustomer() {
		Customer customer =new Customer();
		customer.setCustomerId(2001);
		customer.setCustomerName("Himakar");
		customer.setEmail("himakar@gmail.com");
		customer.setPhoneNumber("9000678590");
		customer.setDeliveryAddress("Ongole");
		customer.setPassword("123456");
		assertEquals(2001, customer.getCustomerId());
		}

	@Test
	void testGetById() {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(2001);
		customerDTO.setCustomerName("Himakar");
		customerDTO.setEmail("himakar@gmail.com");
		customerDTO.setPhoneNumber("9000678590");
		customerDTO.setDeliveryAddress("Ongole");
		customerDTO.setPassword("123456");
		assertEquals(2001, customerDTO.getCustomerId());
		
	}

	@Test
	void testGetAllCustomer() {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(2001);
		customerDTO.setCustomerName("Himakar");
		customerDTO.setEmail("himakar@gmail.com");
		customerDTO.setPhoneNumber("9000678590");
		customerDTO.setDeliveryAddress("Ongole");
		customerDTO.setPassword("123456");	
		}

	@Test
	void testUpdateCustomer() {
		Customer customer =new Customer();
		customer.setCustomerId(2001);
		customer.setCustomerName("Himakar");
		customer.setEmail("himakar@gmail.com");
		customer.setPhoneNumber("9000678590");
		customer.setDeliveryAddress("Ongole");
		customer.setPassword("123456");
		assertEquals(2001, customer.getCustomerId());
	}

	@Test
	void testDeleteById() {
		
	}

	@Test
	void testGetByCustomerName() {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(2001);
		customerDTO.setCustomerName("Himakar");
		customerDTO.setEmail("himakar@gmail.com");
		customerDTO.setPhoneNumber("9000678590");
		customerDTO.setDeliveryAddress("Ongole");
		customerDTO.setPassword("123456");
		assertEquals("Himakar", customerDTO.getCustomerName());
		}

}
