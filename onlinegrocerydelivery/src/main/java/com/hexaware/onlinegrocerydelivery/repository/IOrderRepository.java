package com.hexaware.onlinegrocerydelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.onlinegrocerydelivery.entity.Orders;

public interface IOrderRepository extends JpaRepository<Orders, Integer> {

}
