package com.hexaware.onlinegrocerydelivery.service;

import java.util.List;

import com.hexaware.onlinegrocerydelivery.dto.AdminDTO;
import com.hexaware.onlinegrocerydelivery.dto.CustomerDTO;
import com.hexaware.onlinegrocerydelivery.entity.Admin;

public interface IAdminService {

	public Admin addAdmin(AdminDTO adminDTO);
	
	public AdminDTO getById(int adminId);
	
	public List<Admin> getAllAdmin();
	
	public Admin updateAdmin(AdminDTO adminDTO, int adminId);
	
	void deleteById(int adminId);
	
	public List<AdminDTO> getByUserName(String userName);
	
	
	
	
}
