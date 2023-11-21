package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.onlinegrocerydelivery.dto.CartDTO;
import com.hexaware.onlinegrocerydelivery.entity.Cart;
import com.hexaware.onlinegrocerydelivery.exception.CartNotFoundException;
import com.hexaware.onlinegrocerydelivery.exception.CustomerNotFoundException;
import com.hexaware.onlinegrocerydelivery.repository.ICartRepository;
@Service
public class CartServiceImp implements ICartService {
	@Autowired
	private ICartRepository cartRepository;

	@Override
	public Cart addCart(CartDTO cartDTO) {
		Cart cart=new Cart();
		cart.setCartId(cartDTO.getCartId());
		cart.setCustomerId(cartDTO.getCustomerId());
		cart.setPrice(cartDTO.getPrice());
		cart.setProductId(cartDTO.getProductId());
		cart.setQuantity(cartDTO.getQuantity());
		cart.setTotalAmount(cartDTO.getTotalAmount());
		return cartRepository.save(cart);
	}

	@Override
	public CartDTO getById(int cartId) {
		
		
		Cart cart=cartRepository.findById(cartId).orElse(new Cart());

		if (cart.getCustomerId()==0) {
			throw new CartNotFoundException(HttpStatus.NOT_FOUND," Cart with CartId : " + cartId + " Not Found ");

		}
		
		CartDTO cartDTO =new CartDTO();
		cartDTO.setCartId(cart.getCartId());
		cartDTO.setCustomerId(cart.getCustomerId());
		cartDTO.setPrice(cart.getPrice());
		cartDTO.setProductId(cart.getProductId());
		cartDTO.setQuantity(cart.getQuantity());
		cartDTO.setTotalAmount(cart.getTotalAmount());
		
				return cartDTO;
	}

	@Override
	public List<Cart> getAllCart() {
		return cartRepository.findAll();
	}

	@Override
	public Cart updateCart(CartDTO cartDTO) {
		Cart cart=new Cart();
		cart.setCartId(cartDTO.getCartId());
		cart.setCustomerId(cartDTO.getCustomerId());
		cart.setPrice(cartDTO.getPrice());
		cart.setProductId(cartDTO.getProductId());
		cart.setQuantity(cartDTO.getQuantity());
		cart.setTotalAmount(cartDTO.getTotalAmount());		
		return cartRepository.save(cart);
	}

	@Override
	public String deleteById(int cartId) {
		Cart cart=cartRepository.findById(cartId).orElse(null);
		cartRepository.deleteById(cart.getCartId());
		return "Deleted";
	}

}
