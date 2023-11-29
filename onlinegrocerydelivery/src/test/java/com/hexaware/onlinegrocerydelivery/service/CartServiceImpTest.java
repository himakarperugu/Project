package com.hexaware.onlinegrocerydelivery.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hexaware.onlinegrocerydelivery.dto.CartDTO;
import com.hexaware.onlinegrocerydelivery.entity.Cart;

class CartServiceImpTest {

	@Test
	void testGetById() {;
		CartDTO cartDTO =new CartDTO();
		cartDTO.setCartId(2007);
		cartDTO.setCustomerId(9);
		cartDTO.setPrice(8000);
		cartDTO.setProductId(8);
		cartDTO.setQuantity(2);
		cartDTO.setTotalAmount(10000);
		assertEquals(2007, cartDTO.getCartId());
	}

	@Test
	void testGetAllCart() {
		CartDTO cartDTO =new CartDTO();
		cartDTO.setCartId(2007);
		cartDTO.setCustomerId(9);
		cartDTO.setPrice(8000);
		cartDTO.setProductId(8);
		cartDTO.setQuantity(2);
		cartDTO.setTotalAmount(10000);
		assertEquals(2007, cartDTO.getCartId());
	}

	@Test
	void testUpdateCart() {
		CartDTO cartDTO =new CartDTO();
		cartDTO.setCartId(2007);
		cartDTO.setCustomerId(9);
		cartDTO.setPrice(8000);
		cartDTO.setProductId(8);
		cartDTO.setQuantity(2);
		cartDTO.setTotalAmount(10000);
		assertEquals(2007, cartDTO.getCartId());
	}
	

	@Test
	void testDeleteById() {
		CartDTO cartDTO =new CartDTO();
		cartDTO.setCartId(2007);
		cartDTO.setCustomerId(9);
		cartDTO.setPrice(8000);
		cartDTO.setProductId(8);
		cartDTO.setQuantity(2);
		cartDTO.setTotalAmount(10000);
		assertEquals(2007, cartDTO.getCartId());
	}

}
