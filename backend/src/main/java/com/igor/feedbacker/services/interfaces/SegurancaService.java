package com.igor.feedbacker.services.interfaces;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.igor.feedbacker.entities.Users;

public interface SegurancaService extends UserDetailsService{

	public List<Users> findAll();
	public Users findById(String id);
	public Users insert(Users obj);
	public void delete(String id);
	public Users update(String id, Users obj);
	
}
