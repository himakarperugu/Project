package com.hexaware.onlinegrocerydelivery.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


/*Author:Sakitha
 * Updated:09-11-2023
 *  Description: This is a Substitution Entity Class
 */

@Entity
public class Substitution {
	
	@Id
	private int substitutionId;
	private int orderId;
	private int productId;
	private int substituteProductId;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Orders orders;
	
	
	
	
	public Orders getOrders() {
		return orders;
	}


	public void setOrders(Orders orders) {
		this.orders = orders;
	}


	public Substitution() {
		super();
	}


	public Substitution(int substitutionId, int orderId, int productId, int substituteProductId) {
		super();
		this.substitutionId = substitutionId;
		this.orderId = orderId;
		this.productId = productId;
		this.substituteProductId = substituteProductId;
	}


	public int getSubstitutionId() {
		return substitutionId;
	}


	public void setSubstitutionId(int substitutionId) {
		this.substitutionId = substitutionId;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public int getSubstituteProductId() {
		return substituteProductId;
	}


	public void setSubstituteProductId(int substituteProductId) {
		this.substituteProductId = substituteProductId;
	}


	@Override
	public String toString() {
		return "Substitution [substitutionId=" + substitutionId + ", orderId=" + orderId + ", productId=" + productId
				+ ", substituteProductId=" + substituteProductId + "]";
	}
	
	


	
	
	

}
