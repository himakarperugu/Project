package com.hexaware.onlinegrocerydelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.onlinegrocerydelivery.entity.Cart;

public interface ICartRepository extends JpaRepository<Cart, Integer>{

}
