package com.hexaware.onlinegrocery.services;

import java.util.List;

import com.hexaware.onlinegrocery.entity.Customers;

public interface ICustomersServices {
	
	 public int createCustomer(Customers customer);
	    public int updateCustomer(Customers customer);
	    public Customers getCustomer(int customer_id);
	    public List<Customers> getAllCustomers();
	    public int deleteCustomers(int customer_id);

}
