package com.hexaware.onlinegrocerydelivery.restcontroller;
//Author:Himakar
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	
	
	private ICustomerService customerservice;
	
	

	public CustomerController(ICustomerService customerservice) {
		super();
		this.customerservice = customerservice;
	}

	@PostMapping("/addCustomer")
	public Customer addCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
		
		return customerservice.addCustomer(customerDTO);
	}

	@GetMapping("/getById/{customerId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public CustomerDTO getById(@PathVariable int customerId) {
		
		return customerservice.getById(customerId);
		
	}

	@GetMapping("/getAllCustomer")
	@PreAuthorize("hasAnyAuthority('ADMIN','CUSTOMER')")
	public List<Customer> getAllCustomer() {
		
		return customerservice.getAllCustomer();
	}

	@PutMapping("/updateCustomer/{customerId}")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")
    public Customer updateCustomerByCustomerId(@RequestBody CustomerDTO customerDTO) {
        return customerservice.updateCustomerByCustomerId(customerDTO);
    }


	@DeleteMapping("/deleteById/{customerId}")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")
	public void deleteById(int customerId) {
		
		customerservice.deleteById(customerId);

	}
	@GetMapping("/getByCustomerName/{customerName}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public List<CustomerDTO> getByCustomerName(@PathVariable String customerName) {
	
		return customerservice.getByCustomerName(customerName);
	}
	
}
