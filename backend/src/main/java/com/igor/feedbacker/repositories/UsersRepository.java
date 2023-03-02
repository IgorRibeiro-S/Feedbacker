package com.igor.feedbacker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor.feedbacker.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
	
	public Users findByEmail(String email);

	public Users findByNameAndPassword(String name, String password);
}
