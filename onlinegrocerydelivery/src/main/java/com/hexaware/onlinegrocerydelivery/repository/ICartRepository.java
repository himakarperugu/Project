package com.hexaware.onlinegrocerydelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hexaware.onlinegrocerydelivery.entity.Cart;

public interface ICartRepository extends JpaRepository<Cart, Integer>{

	List<Cart> findByCustomerId(int customerId);
	@Query("FROM Cart c WHERE c.customer.customerId = :customerId")
	List<Cart> findCustomerByCustomerId(@Param("customerId") int customerId);

	
	
	

}
