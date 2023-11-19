package com.hexaware.onlinegrocerydelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.onlinegrocerydelivery.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	List<Admin> getByUserName(String userName);


	
	
	
}
