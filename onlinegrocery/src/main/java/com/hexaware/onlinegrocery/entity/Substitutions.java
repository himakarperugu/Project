package com.hexaware.onlinegrocery.entity;

import java.util.Objects;

public class Substitutions {
	
	private int substitution_id;
	private int order_id;
	private int product_id;
	private int substitute_product_id;
	
	public Substitutions() {
		// TODO Auto-generated constructor stub
	}

	public Substitutions(int substitution_id, int order_id, int product_id, int substitute_product_id) {
		super();
		this.substitution_id = substitution_id;
		this.order_id = order_id;
		this.product_id = product_id;
		this.substitute_product_id = substitute_product_id;
	}

	public int getSubstitution_id() {
		return substitution_id;
	}

	public void setSubstitution_id(int substitution_id) {
		this.substitution_id = substitution_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getSubstitute_product_id() {
		return substitute_product_id;
	}

	public void setSubstitute_product_id(int substitute_product_id) {
		this.substitute_product_id = substitute_product_id;
	}

	@Override
	public String toString() {
		return "Substitutions [substitution_id=" + substitution_id + ", order_id=" + order_id + ", product_id="
				+ product_id + ", substitute_product_id=" + substitute_product_id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(order_id, product_id, substitute_product_id, substitution_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Substitutions other = (Substitutions) obj;
		return order_id == other.order_id && product_id == other.product_id
				&& substitute_product_id == other.substitute_product_id && substitution_id == other.substitution_id;
	}

}
