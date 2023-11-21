package com.hexaware.onlinegrocerydelivery.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


/*Author:Himakar
 * Updated:09-11-2023
 *  Description: This is a Admin DTO Class
 */


public class AdminDTO {
	@NotNull(message="Id should not be null")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	@NotBlank(message="Username should not be blank")
	@Size(min=2,max=255,message="Username should be between 2-255 characters")
	private String userName;
	@NotBlank(message = "Password should not be blank")
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$")
    @Size(min=8,message="Password must be at least 4 characters long")
	private String password;
	private String role;

	
	public AdminDTO() {
		super();
	}


	


	public AdminDTO(int adminId,
			String userName,
			String password,
			String role) {
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
		return "AdminDTO [adminId=" + adminId + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	


	
}
