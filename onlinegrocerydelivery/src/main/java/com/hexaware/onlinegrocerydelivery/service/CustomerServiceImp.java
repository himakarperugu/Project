package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.onlinegrocerydelivery.dto.CustomerDTO;
import com.hexaware.onlinegrocerydelivery.entity.Customer;
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
		logger.info("addCustomer method is implemented");
		return customerrepository.save(customer);
	}

	@Override
	public CustomerDTO getById(int customerId) {
		Customer customer = customerrepository.findById(customerId).orElse(null);
		
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setCustomerName(customer.getCustomerName());
		customerDTO.setEmail(customer.getEmail());
		customerDTO.setPhoneNumber(customer.getPhoneNumber());
		customerDTO.setDeliveryAddress(customer.getDeliveryAddress());
		logger.info("getById method is implemented");
		
		
		return customerDTO;
	}

	@Override
	public List<Customer> getAllCustomer() {
		
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
		logger.info("updateCustomer method is implemented");
		
		return customerrepository.save(customer);	
	}

	@Override
	public void deleteById(int customerId) {
		Customer customer=customerrepository.findById(customerId).orElse(null);
		customerrepository.deleteById(customer.getCustomerId());
		logger.info("deleteById method is implemented");

	}

	@Override
	public List<CustomerDTO> getByCustomerName(String customerName) {
		 List<Customer> customers = customerrepository.getByCustomerName(customerName);

		    return customers.stream()
		            .map(customer -> new CustomerDTO(
		            		customer.getCustomerId(),
		            		customer.getCustomerName(),
		            		customer.getEmail(),
		            		customer.getPhoneNumber(),
		            		customer.getDeliveryAddress()
		                   
		            ))
		            .collect(Collectors.toList());
	}

}
