package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;

import com.hexaware.onlinegrocerydelivery.dto.CartDTO;
import com.hexaware.onlinegrocerydelivery.entity.Cart;

public interface ICartService {
	
	Cart  addCart(CartDTO cartDTO, int productId);
	CartDTO getById(int cartId);
	List<Cart> getAllCart();
	Cart  updateCart(CartDTO cartDTO);
	String deleteById(int cartId);
	

}
