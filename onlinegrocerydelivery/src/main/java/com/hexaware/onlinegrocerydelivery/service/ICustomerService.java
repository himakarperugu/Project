package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;

import com.hexaware.onlinegrocerydelivery.dto.CustomerDTO;

import com.hexaware.onlinegrocerydelivery.entity.Customer;

public interface ICustomerService {
	
	public Customer addCustomer(CustomerDTO customerDTO);

	public CustomerDTO getById(int customerId);

	public List<Customer> getAllCustomer();

	public Customer updateCustomerByCustomerId(CustomerDTO customerDTO);

	public void deleteById(int customerId);
	
	public List<CustomerDTO> getByCustomerName(String customerName);

}
