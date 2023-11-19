package com.hexaware.onlinegrocerydelivery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


/* Author:Himakar
 * @UpdatedOn:09-11-2023
 * Description: This is a Admin Entity Class
 */

@Entity
public class Admin {
	
	
	@Id
	private int adminId;
    private String userName;
    private String password;
    private String role;
	
	public Admin() {
		super();
	}

	public Admin(int adminId, String userName, String password, String role) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
		this.role = role;
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


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	


	
	
	
	

}
