package com.igor.feedbacker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.igor.feedbacker.entities.Feedbacks;
import com.igor.feedbacker.entities.Users;
import com.igor.feedbacker.repositories.FeedbacksRepository;
import com.igor.feedbacker.repositories.UsersRepository;

@Configuration
@Profile("prod")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private FeedbacksRepository feedbacksRepository;
	
	PasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public void run(String... args) throws Exception {
		Users u1 = new Users("Doublas", "Doug@gmail.com", encoder.encode("456789"), "ROLE_ADMIN");
		Feedbacks f1 = new Feedbacks(null, "idea", "texto","teste", null, "chrome", "pg1", u1 );
		Feedbacks f2 = new Feedbacks(null, "other", "texto","teste", null, "chrome", "pg1", u1 );
		Feedbacks f3 = new Feedbacks(null, "issue", "texto","teste", null, "chrome", "pg1", u1 );
		Feedbacks f4 = new Feedbacks(null, "issue", "texto","teste",null, "chrome", "pg1", u1 );
		Feedbacks f5 = new Feedbacks(null, "issue", "texto","teste", null, "chrome", "pg1", u1 );
		
		userRepository.save(u1);
		feedbacksRepository.save(f1);
		feedbacksRepository.save(f2);
		feedbacksRepository.save(f3);
		feedbacksRepository.save(f4);
		feedbacksRepository.save(f5);
	}

}