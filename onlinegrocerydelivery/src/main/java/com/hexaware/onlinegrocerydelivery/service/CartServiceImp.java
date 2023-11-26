package com.hexaware.onlinegrocerydelivery.service;


import java.util.List;

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

    @Override
    public Cart addCart(CartDTO cartDTO, int productId) {
        Customer customer = customerRepository.findById(cartDTO.getCustomerId()).orElse(null);

        if (customer == null) {
            throw new CustomerNotFoundException(HttpStatus.NOT_FOUND,
                    " Customer with CustomerId : " + cartDTO.getCustomerId() + " Not Found ");
        }

        Product product = productRepository.findById(productId).orElse(null);

        if (product == null) {
            throw new ProductNotFoundException(HttpStatus.NOT_FOUND,
                    " Product with ProductId : " + productId + " Not Found ");
        }

        Cart cart = new Cart();
        cart.setCustomer(customer);
        cart.setProduct(product);
        cart.setCartId(cartDTO.getCartId());
        cart.setCustomerId(cartDTO.getCustomerId());
       // cart.setProductId(product.getProductId()); 
        cart.setQuantity(cartDTO.getQuantity());

        long totalAmount = product.getPrice() * cartDTO.getQuantity();
        cart.setTotalAmount(totalAmount);

        return cartRepository.save(cart);
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
       // cartDTO.setProductId(cart.getProductId());
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
        // existingCart.setProductId(cartDTO.getProductId());
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
