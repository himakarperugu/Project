package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.onlinegrocerydelivery.dto.CustomerDTO;
import com.hexaware.onlinegrocerydelivery.entity.Customer;
import com.hexaware.onlinegrocerydelivery.exception.CustomerNotFoundException;
import com.hexaware.onlinegrocerydelivery.repository.ICustomerRepository;
//Author:Himakar

@Service
public class CustomerServiceImp implements ICustomerService {

	Logger logger = LoggerFactory.getLogger(CustomerServiceImp.class);
	
	@Autowired
	private ICustomerRepository customerRepository;
	private  PasswordEncoder passwordEncoder;	
	
	

	public CustomerServiceImp(ICustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
		super();
		this.customerRepository = customerRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Customer addCustomer(CustomerDTO customerDTO) {
		
		Customer customer =new Customer();
		
		
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setCustomerName(customerDTO.getCustomerName());
		customer.setEmail(customerDTO.getEmail());
		customer.setPhoneNumber(customerDTO.getPhoneNumber());
		customer.setDeliveryAddress(customerDTO.getDeliveryAddress());
		customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
		

		logger.info("Inserted Customer Data Into Table "+ customerDTO);
		return customerRepository.save(customer);
	}

	@Override
	public CustomerDTO getById(int customerId) {
		Customer customer = customerRepository.findById(customerId).orElse(new Customer());
		
		
		if (customer.getCustomerId()==0) {
			throw new CustomerNotFoundException(HttpStatus.NOT_FOUND," Customer with CustomerId : " + customerId + " Not Found ");

		}
		
		
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setCustomerName(customer.getCustomerName());
		customerDTO.setEmail(customer.getEmail());
		customerDTO.setPhoneNumber(customer.getPhoneNumber());
		customerDTO.setDeliveryAddress(customer.getDeliveryAddress());
		customerDTO.setPassword(passwordEncoder.encode(customer.getPassword()));
		logger.info("Fetched Customer Data Using Customer ID " + customerId);
		
		
		return customerDTO;
	}

	@Override
	public List<Customer> getAllCustomer() {
		logger.info(" Fetched All The Customer Data ");
		return customerRepository.findAll();
	}

	public Customer updateCustomerByCustomerId(CustomerDTO customerDTO) {
        Customer customer = new Customer();

        // Retrieve existing customer from the repository by customer ID
        Customer existingCustomer = customerRepository.findById(customerDTO.getCustomerId()).orElse(null);

        // Update customer information if the existing customer is found
        if (existingCustomer != null) {
            existingCustomer.setCustomerName(customerDTO.getCustomerName());
            existingCustomer.setEmail(customerDTO.getEmail());
            existingCustomer.setPhoneNumber(customerDTO.getPhoneNumber());
            existingCustomer.setDeliveryAddress(customerDTO.getDeliveryAddress());
            existingCustomer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));

            // Save the updated customer back to the repository
            customer = customerRepository.save(existingCustomer);
        } else {
            // Log a warning if the customer with the given ID is not found
            logger.warn("Customer with Customer ID " + customerDTO.getCustomerId() + " not found.");
        }

        // Log an informational message about the update
        logger.info("Updated Customer Data Into Table " + customerDTO);

        // Return the updated customer
        return customer;
    }

	@Override
	public void deleteById(int customerId) {
	    Customer customer = customerRepository.findById(customerId).orElse(null);

	    if (customer != null) {
	    	customerRepository.deleteById(customer.getCustomerId());
	        logger.info("Deleting the Customer Record Using Customer ID " + customerId);
	    } else {
	        logger.warn("Customer with Customer ID " + customerId + " not found. No Deletion Operation is performed.");
	    }
	}


	@Override
	public List<CustomerDTO> getByCustomerName(String customerName) {
		 List<Customer> customers = customerRepository.getByCustomerName(customerName);
		 
		 if (customers.isEmpty()) {
		        throw new CustomerNotFoundException(HttpStatus.NOT_FOUND, "Customer with Customer Name: " + customerName + " Not Found");
		    }

		 
		 
		    return customers.stream()
		            .map(customer -> new CustomerDTO(
		            		customer.getCustomerId(),
		            		customer.getCustomerName(),
		            		customer.getEmail(),
		            		customer.getPhoneNumber(),
		            		customer.getDeliveryAddress(),
		            		customer.getPassword()
		                   
		            ))
		            .collect(Collectors.toList());
	}
}

