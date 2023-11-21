package com.hexaware.onlinegrocerydelivery.restcontroller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.onlinegrocerydelivery.dto.OrderDTO;
import com.hexaware.onlinegrocerydelivery.entity.Orders;
import com.hexaware.onlinegrocerydelivery.service.IOrderService;

import jakarta.validation.Valid;
//Author:sakitha

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
	
	
	private IOrderService orderservice;
	

	public OrderController(IOrderService  orderservice) {
		super();
		this.orderservice = orderservice;
	}


	@PostMapping("/addOrder")
	public Orders addOrder(@Valid @RequestBody OrderDTO orderDTO) {
		
		return orderservice.addOrder(orderDTO);
	}

	
	@GetMapping("/getById/{orderId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public OrderDTO getById(@PathVariable int orderId) {
		
		return orderservice.getById(orderId);
		
	}
	

	@GetMapping("/getAllOrder")
	@PreAuthorize("hasAnyAuthority('ADMIN','CUSTOMER')")

	public List<Orders> getAllOrder() {
		
		return orderservice.getAllOrder();
	}
	
	@PutMapping("/updateOrder")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")
	public Orders updateOrder(@RequestBody OrderDTO OrderDTO) {
		
		return orderservice.updateOrder(OrderDTO);
	}
	
	@DeleteMapping("/deleteById/{orderId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public void deleteById(int orderId) {
		
		orderservice.deleteById(orderId);
	}


}
