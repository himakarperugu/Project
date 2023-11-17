package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.onlinegrocerydelivery.dto.CustomerDTO;
import com.hexaware.onlinegrocerydelivery.entity.Customer;
import com.hexaware.onlinegrocerydelivery.exception.AdminNotFoundException;
import com.hexaware.onlinegrocerydelivery.exception.CustomerNotFoundException;
import com.hexaware.onlinegrocerydelivery.repository.CustomerRepository;
@Service
public class CustomerServiceImp implements ICustomerService {

	Logger logger = LoggerFactory.getLogger(CustomerServiceImp.class);
	
	private CustomerRepository customerrepository;
	@Autowired
	public CustomerServiceImp(CustomerRepository customerrepository) {
		super();
		this.customerrepository = customerrepository;
	}

	@Override
	public Customer addCustomer(CustomerDTO customerDTO) {
		
		Customer customer =new Customer();
		
		
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setCustomerName(customerDTO.getCustomerName());
		customer.setEmail(customerDTO.getEmail());
		customer.setPhoneNumber(customerDTO.getPhoneNumber());
		customer.setDeliveryAddress(customerDTO.getDeliveryAddress());
	
		customer.setOrder( customerDTO.getOrder());
		logger.info("Inserted Customer Data Into Table "+ customerDTO);
		return customerrepository.save(customer);
	}

	@Override
	public CustomerDTO getById(int customerId) {
		Customer customer = customerrepository.findById(customerId).orElse(new Customer());
		
		
		if (customer.getCustomerId()==0) {
			throw new CustomerNotFoundException(HttpStatus.NOT_FOUND," Customer with CustomerId : " + customerId + " Not Found ");

		}
		
		
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setCustomerName(customer.getCustomerName());
		customerDTO.setEmail(customer.getEmail());
		customerDTO.setPhoneNumber(customer.getPhoneNumber());
		customerDTO.setDeliveryAddress(customer.getDeliveryAddress());
		logger.info("Fetched Customer Data Using Customer ID " + customerId);
		
		
		return customerDTO;
	}

	@Override
	public List<Customer> getAllCustomer() {
		logger.info(" Fetched All The Customer Data ");
		return customerrepository.findAll();
	}

	@Override
	public Customer updateCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		
		
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setCustomerName(customerDTO.getCustomerName());
		customer.setEmail(customerDTO.getEmail());
		customer.setPhoneNumber(customerDTO.getPhoneNumber());
		customer.setDeliveryAddress(customerDTO.getDeliveryAddress());
		logger.info(" Updated Customer Data Into Table " + customerDTO);
		
		return customerrepository.save(customer);	
	}

	@Override
	public void deleteById(int customerId) {
		Customer customer=customerrepository.findById(customerId).orElse(null);
		customerrepository.deleteById(customer.getCustomerId());
		logger.info("Deleting the Customer Record Using Customer ID " + customerId);

	}

	/*@Override
	public CustomerDTO getByCustomerName(String customerName) {
		
		Customer customer=customerrepository.findByCustomerName(customerName);
		if (customer.isEmpty()) {
	        throw new CustomerNotFoundException(HttpStatus.NOT_FOUND, "Customers with customerName: " + customerName + " not found");
		}
		
		CustomerDTO customerDTO=new CustomerDTO();
		if(customer!=null) {
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setCustomerName(customer.getCustomerName());
			customerDTO.setEmail(customer.getEmail());
			customerDTO.setPhoneNumber(customer.getPhoneNumber());
			customerDTO.setDeliveryAddress(customer.getDeliveryAddress());
			logger.info("Fetching customer by name" +customer.getCustomerName());

		}
		
		return customerDTO;
		
		
		
	}*/


	}


