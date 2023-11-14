package com.hexaware.onlinegrocerydelivery.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	
	private IOrderService service;
	
	@Autowired
	public OrderController(IOrderService service) {
		super();
		this.service = service;
	}


	@PostMapping("/addOrder")
	public Orders addOrder(@RequestBody OrderDTO orderDTO) {
		
		return service.addOrder(orderDTO);
	}

	
	@GetMapping("/getById/{orderId}")
	public OrderDTO getById(@PathVariable int orderId) {
		
		return service.getById(orderId);
		
	}
	

	@GetMapping("/getAllOrder")
	public List<Orders> getAllOrder() {
		
		return service.getAllOrder();
	}
	
	@PutMapping("/updateOrder")
	public Orders updateOrder(@RequestBody OrderDTO OrderDTO) {
		
		return service.updateOrder(OrderDTO);
	}
	
	@DeleteMapping("/deleteById/{orderId}")
	public void deleteById(int orderId) {
		
		service.deleteById(orderId);
	}


}
