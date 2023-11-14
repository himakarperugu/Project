package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.onlinegrocerydelivery.dto.CustomerDTO;
import com.hexaware.onlinegrocerydelivery.entity.Customer;
import com.hexaware.onlinegrocerydelivery.repository.CustomerRepository;
@Service
public class CustomerServiceImp implements ICustomerService {

	
	
	private CustomerRepository repo;
	@Autowired
	public CustomerServiceImp(CustomerRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Customer addCustomer(CustomerDTO customerDTO) {
		
		Customer customer =new Customer();
		
		
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setCustomerName(customerDTO.getCustomerName());
		customer.setEmail(customerDTO.getEmail());
		customer.setPhoneNumber(customerDTO.getPhoneNumber());
		customer.setDeliveryAddress(customerDTO.getDeliveryAddress());
	
		
		return repo.save(customer);
	}

	@Override
	public CustomerDTO getById(int customerId) {
		Customer customer = repo.findById(customerId).orElse(null);
		
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setCustomerName(customer.getCustomerName());
		customerDTO.setEmail(customer.getEmail());
		customerDTO.setPhoneNumber(customer.getPhoneNumber());
		customerDTO.setDeliveryAddress(customer.getDeliveryAddress());
		
		
		return customerDTO;
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return repo.findAll();
	}

	@Override
	public Customer updateCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		
		
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setCustomerName(customerDTO.getCustomerName());
		customer.setEmail(customerDTO.getEmail());
		customer.setPhoneNumber(customerDTO.getPhoneNumber());
		customer.setDeliveryAddress(customerDTO.getDeliveryAddress());
		
		return repo.save(customer);	
	}

	@Override
	public void deleteById(int customerId) {
		Customer customer=repo.findById(customerId).orElse(null);
		repo.deleteById(customer.getCustomerId());

	}

	@Override
	public List<CustomerDTO> getByCustomerName(String customerName) {
		 List<Customer> customers = repo.getByCustomerName(customerName);

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
