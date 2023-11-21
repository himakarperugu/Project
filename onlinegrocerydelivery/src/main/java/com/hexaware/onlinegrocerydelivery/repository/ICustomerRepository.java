package com.hexaware.onlinegrocerydelivery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.onlinegrocerydelivery.entity.Customer;
//Author:Himakar

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
	List<Customer> getByCustomerName(String customerName);
	 Optional<Customer> findByCustomerName(String customerName);
	public Customer findByCustomerNameAndPassword( String customerName, String password);

}
