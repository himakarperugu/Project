package com.hexaware.onlinegrocery.services;

import java.util.List;

import com.hexaware.onlinegrocery.entity.Admin;

public interface IAdminServices {
	
	   public int  createAdmin(Admin admin);
	   public int updateAdmin(Admin admin);
	    public Admin getAdmin(int admin_id);
	    public List<Admin> getAllAdmin();
	   public int deleteAdmin(int admin_id);
	

}
