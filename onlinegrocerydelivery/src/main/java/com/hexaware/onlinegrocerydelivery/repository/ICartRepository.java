package com.hexaware.onlinegrocerydelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.onlinegrocerydelivery.entity.Cart;

public interface ICartRepository extends JpaRepository<Cart, Integer>{

	List<Cart> findByCustomerId(int customerId);
	
	
	
	

}
