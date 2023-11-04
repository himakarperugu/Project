package com.hexaware.onlinegrocery.entity;

import java.util.Date;
import java.util.Objects;





public class Orders {
	
	
	private int order_id;
	private int customer_id;
	private Date order_date;
	private String delivery_address;
	private String payment_method;
	private double total_amount;
	
	
	

	public Orders() {
		// TODO Auto-generated constructor stub
	}



	public Orders(int order_id, int customer_id, Date order_date, String delivery_address, String payment_method,
			float total_amount) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.order_date = order_date;
		this.delivery_address = delivery_address;
		this.payment_method = payment_method;
		this.total_amount = total_amount;
	}



	public int getOrder_id() {
		return order_id;
	}



	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}



	public int getCustomer_id() {
		return customer_id;
	}



	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}



	public Date getOrder_date() {
		return order_date;
	}



	public void setOrder_date(Date date) {
		this.order_date = date;
	}



	public String getDelivery_address() {
		return delivery_address;
	}



	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}



	public String getPayment_method() {
		return payment_method;
	}



	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}



	public double getTotal_amount() {
		return total_amount;
	}



	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}



	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", customer_id=" + customer_id + ", order_date=" + order_date
				+ ", delivery_address=" + delivery_address + ", payment_method=" + payment_method + ", total_amount="
				+ total_amount + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(customer_id, delivery_address, order_date, order_id, payment_method, total_amount);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return customer_id == other.customer_id && Objects.equals(delivery_address, other.delivery_address)
				&& Objects.equals(order_date, other.order_date) && order_id == other.order_id
				&& Objects.equals(payment_method, other.payment_method)
				&& Double.doubleToLongBits(total_amount) == Double.doubleToLongBits(other.total_amount);
	}



	

}
