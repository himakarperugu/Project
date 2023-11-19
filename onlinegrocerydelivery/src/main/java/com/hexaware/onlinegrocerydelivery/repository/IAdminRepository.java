package com.hexaware.onlinegrocerydelivery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.onlinegrocerydelivery.entity.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Integer>{

	List<Admin> getByUserName(String userName);

	public Admin findByUserNameAndPassword(String userName, String Password);
	 Optional<Admin> findByUserName(String userName);
	
	
	
}
