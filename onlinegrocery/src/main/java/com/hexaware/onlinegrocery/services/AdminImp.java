package com.hexaware.onlinegrocery.services;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.onlinegrocery.entity.Admin;

public class AdminImp implements IAdminServices {

	@Override
	public int createAdmin(Admin admin) {
		
		return 1;
	}

	@Override
	public int updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return 1;
	}
	

	@Override
	public Admin getAdmin(int admin_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> a = new ArrayList <Admin>();
		a.add(new Admin(14,"himakar","HI@43"));
		return a;
	}

	@Override
	public int deleteAdmin(int admin_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
