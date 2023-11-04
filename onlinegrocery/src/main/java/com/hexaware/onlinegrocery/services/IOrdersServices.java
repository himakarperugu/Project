package com.hexaware.onlinegrocery.services;

import java.util.List;

import com.hexaware.onlinegrocery.entity.Orders;

public interface IOrdersServices {
    public int createOrder(Orders order);
    public int updateOrder(Orders order);
    public Orders getOrder(int order_id);
    public List<Orders> getAllOrders();
    public int deleteOrder(int order_id);
    
    
}
