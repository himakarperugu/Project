package com.hexaware.onlinegrocerydelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.onlinegrocerydelivery.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	List<Customer> getByCustomerName(String customerName);

}
