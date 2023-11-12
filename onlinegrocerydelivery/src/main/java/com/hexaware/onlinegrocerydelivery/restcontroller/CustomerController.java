package com.hexaware.onlinegrocerydelivery.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.onlinegrocerydelivery.dto.CustomerDTO;
import com.hexaware.onlinegrocerydelivery.entity.Customer;
import com.hexaware.onlinegrocerydelivery.service.ICustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	
	@Autowired
	ICustomerService service;
	
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody CustomerDTO customerDTO) {
		
		return service.addCustomer(customerDTO);
	}

	@GetMapping("/getById/{customerId}")
	public CustomerDTO getById(@PathVariable int customerId) {
		
		return service.getById(customerId);
		
	}

	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomer() {
		
		return service.getAllCustomer();
	}

	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody CustomerDTO customerDTO) {
		
		return service.updateCustomer(customerDTO);
	}

	@DeleteMapping("/deleteById/{customerId}")
	public void deleteById(int customerId) {
		
		service.deleteById(customerId);

	}
	@GetMapping("/getByCustomerName/{customerName}")
	public List<CustomerDTO> getByCustomerName(@PathVariable String customerName) {
	
		return service.getByCustomerName(customerName);
	}
	
}
