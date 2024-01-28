package com.hexaware.onlinegrocerydelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hexaware.onlinegrocerydelivery.entity.Cart;
import com.hexaware.onlinegrocerydelivery.entity.Orders;
//Author:sakitha

public interface IOrderRepository extends JpaRepository<Orders, Integer> {
	 @Query("SELECT o FROM Orders o WHERE o.customer.customerId = :customerId")
	    List<Orders> findOrdersByCustomerId(@Param("customerId") int customerId);

}
