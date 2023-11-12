package com.hexaware.onlinegrocerydelivery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
	
	
	@Id
	private int adminId;
	private String userName;
	private String password;
	
	
	public Admin() {
		super();
	}


	public Admin(int adminId, String userName, String password) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
	}


	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", userName=" + userName + ", password=" + password + "]";
	}


	
	
	
	

}
