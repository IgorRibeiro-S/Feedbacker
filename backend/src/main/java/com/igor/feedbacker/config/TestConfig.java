package com.igor.feedbacker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.igor.feedbacker.entities.Users;
import com.igor.feedbacker.repositories.UsersRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsersRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		Users u1 = new Users("Doublas", "Doug@gmail.com", "1234");
	
		userRepository.save(u1);
	}

}