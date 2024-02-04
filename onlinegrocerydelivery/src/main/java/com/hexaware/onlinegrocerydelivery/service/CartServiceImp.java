package com.hexaware.onlinegrocerydelivery.service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.onlinegrocerydelivery.dto.CartDTO;
import com.hexaware.onlinegrocerydelivery.entity.Cart;
import com.hexaware.onlinegrocerydelivery.entity.Customer;
import com.hexaware.onlinegrocerydelivery.entity.Product;
import com.hexaware.onlinegrocerydelivery.exception.CartNotFoundException;
import com.hexaware.onlinegrocerydelivery.exception.CustomerNotFoundException;
import com.hexaware.onlinegrocerydelivery.exception.ProductNotFoundException;
import com.hexaware.onlinegrocerydelivery.repository.ICartRepository;
import com.hexaware.onlinegrocerydelivery.repository.ICustomerRepository;
import com.hexaware.onlinegrocerydelivery.repository.IProductRepository;

@Service
public class CartServiceImp implements ICartService {

    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IProductRepository productRepository;

    public CartServiceImp(ICartRepository cartRepository, ICustomerRepository customerRepository,
            IProductRepository productRepository) {
        super();
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

//    @Override
//    public Cart addCart(CartDTO cartDTO) {
//        Customer customer = customerRepository.findById(cartDTO.getCustomerId()).orElse(null);
//
//        if (customer == null) {
//            throw new CustomerNotFoundException(HttpStatus.NOT_FOUND,
//                    " Customer with CustomerId : " + cartDTO.getCustomerId() + " Not Found ");
//        }
//
//        // Check if a Cart already exists for this Customer
//        List<Cart> existingCarts = cartRepository.findByCustomerId(cartDTO.getCustomerId());
//
//        if (!existingCarts.isEmpty()) {
//            // If a Cart already exists, update the first one
//            Cart existingCart = existingCarts.get(0);
//            existingCart.setQuantity(cartDTO.getQuantity());
//            existingCart.setTotalAmount(cartDTO.getTotalAmount());
//            return cartRepository.save(existingCart);
//        } else {
//            // If no Cart exists, create a new one
//            Cart cart = new Cart();
//            cart.setCustomer(customer);
//            cart.setCartId(cartDTO.getCartId());
//            cart.setCustomerId(cartDTO.getCustomerId());
//            cart.setQuantity(cartDTO.getQuantity());
//            cart.setTotalAmount(cartDTO.getTotalAmount());
//            return cartRepository.save(cart);
//        }
//    }
    
    
    //new code for add code to add new element insead of replacing exliting data 
    @Override
    public Cart addCart(CartDTO cartDTO) {
        Customer customer = customerRepository.findById(cartDTO.getCustomerId()).orElse(null);

        if (customer == null) {
            throw new CustomerNotFoundException(HttpStatus.NOT_FOUND,
                    " Customer with CustomerId : " + cartDTO.getCustomerId() + " Not Found ");
        }

        // Retrieve existing carts for the customer
        List<Cart> existingCarts = cartRepository.findByCustomerId(cartDTO.getCustomerId());

        if (!existingCarts.isEmpty()) {
            // If carts exist, create a new cart and append it to the existing list
            Cart newCart = new Cart();
            newCart.setCustomer(customer);
            newCart.setCartId(cartDTO.getCartId());
            newCart.setCustomerId(cartDTO.getCustomerId());
            newCart.setQuantity(cartDTO.getQuantity());
            newCart.setTotalAmount(cartDTO.getTotalAmount());

            existingCarts.add(newCart);

            // Save the updated list of carts
            return cartRepository.saveAll(existingCarts).get(existingCarts.size() - 1); // Return the last added cart
        } else {
            // If no carts exist, create a new one
            Cart cart = new Cart();
            cart.setCustomer(customer);
            cart.setCartId(cartDTO.getCartId());
            cart.setCustomerId(cartDTO.getCustomerId());
            cart.setQuantity(cartDTO.getQuantity());
            cart.setTotalAmount(cartDTO.getTotalAmount());
            return cartRepository.save(cart);
        }
    }

    
    
    @Override
    public List<CartDTO> getByCustomerId(int customerId) {
    	List<Cart> cartList = cartRepository.findCustomerByCustomerId(customerId);
	    List<CartDTO> cartDTOList = new ArrayList<>();

	    for (Cart cart : cartList) {
	        CartDTO cartDTO = new CartDTO();

	        cartDTO.setCustomerId(cart.getCustomer().getCustomerId());

	        cartDTO.setCartId(cart.getCartId());

	       
	        cartDTO.setQuantity(cart.getQuantity());

	        cartDTO.setTotalAmount(cart.getTotalAmount());

	        cartDTOList.add(cartDTO);
	    }

        return cartDTOList;
    } 
    

    @Override
    public CartDTO getById(int cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(new Cart());

        if (cart.getCustomerId() == 0) {
            throw new CartNotFoundException(HttpStatus.NOT_FOUND, " Cart with CartId : " + cartId + " Not Found ");
        }

        CartDTO cartDTO = new CartDTO();
        cartDTO.setCartId(cart.getCartId());
        cartDTO.setCustomerId(cart.getCustomerId());
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
        Cart existingCart = cartRepository.findById(cartDTO.getCartId())
                .orElseThrow(() -> new CartNotFoundException(HttpStatus.NOT_FOUND,
                        "Cart with id: " + cartDTO.getCartId() + " not found"));

        existingCart.setCustomerId(cartDTO.getCustomerId());
        existingCart.setQuantity(cartDTO.getQuantity());
        existingCart.setTotalAmount(cartDTO.getTotalAmount());

        // Save the updated Cart entity back to the database
        return cartRepository.save(existingCart);
    }


    @Override
    public String deleteById(int cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        cartRepository.deleteById(cart.getCartId());
        return "Deleted";
    }
     
}
