package com.hexaware.onlinegrocerydelivery.dto;

public class SubstitutionDTO {

	private int substitutionId;
	private int orderId;
	private int productId;
	private int substituteProductId;
	
	public SubstitutionDTO() {
		super();
	}

	public SubstitutionDTO(int substitutionId, int orderId, int productId, int substituteProductId) {
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
		return "SubstitutionDTO [substitutionId=" + substitutionId + ", orderId=" + orderId + ", productId=" + productId
				+ ", substituteProductId=" + substituteProductId + "]";
	}

	

}
