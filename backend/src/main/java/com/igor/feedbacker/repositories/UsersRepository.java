package com.igor.feedbacker.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.feedbacker.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	default Optional<Users> findById(UUID id) {
		return Optional.empty();
	}
	
	default void deleteById(UUID id) {
	}
}
