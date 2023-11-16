package com.hexaware.onlinegrocerydelivery.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AdminDTO {
	private int adminId;
	@NotBlank(message="Username should not be blank")
	@Size(min=8,max=20,message="Username should be between 8-20 characters")
	private String userName;
	@NotBlank(message = "Password should not be blank")
    @Size(min=6,message="Password must be at least 8 characters long")
   /* @Pattern.List({
        @Pattern(regexp = "(?=.*[0-9]).+", message = "Password must contain at least one digit"),
        @Pattern(regexp = "(?=.*[a-z]).+", message = "Password must contain at least one lowercase letter"),
        @Pattern(regexp = "(?=.*[A-Z]).+", message = "Password must contain at least one uppercase letter"),
        @Pattern(regexp = "(?=.*[!@#$%^&*()\\-_=+{};:',.<>?/]).+", message = "Password must contain at least one special character")
    })*/
	private String password;

	
	public AdminDTO() {
		super();
	}


	public AdminDTO(int adminId, String userName, String password) {
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
		return "AdminDTO [adminId=" + adminId + ", userName=" + userName + ", password=" + password + "]";
	}


	
}
