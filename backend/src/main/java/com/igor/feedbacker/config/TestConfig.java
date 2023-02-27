package com.igor.feedbacker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.igor.feedbacker.entities.Feedbacks;
import com.igor.feedbacker.entities.Users;
import com.igor.feedbacker.repositories.FeedbacksRepository;
import com.igor.feedbacker.repositories.UsersRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private FeedbacksRepository feedbacksRepository;

	@Override
	public void run(String... args) throws Exception {
		Users u1 = new Users("Doublas", "Doug@gmail.com", "456789");
		Feedbacks f1 = new Feedbacks("idea", "texto","teste", "1212121", "chrome", "pg1" );
		Feedbacks f2 = new Feedbacks("other", "texto","teste", "1212121", "chrome", "pg1" );
		Feedbacks f3 = new Feedbacks("issue", "texto","teste", "1212121", "chrome", "pg1" );
		Feedbacks f4 = new Feedbacks("issue", "texto","teste", "1212121", "chrome", "pg1" );
		Feedbacks f5 = new Feedbacks("issue", "texto","teste", "1212121", "chrome", "pg1" );
		
		userRepository.save(u1);
		feedbacksRepository.save(f1);
		feedbacksRepository.save(f2);
		feedbacksRepository.save(f3);
		feedbacksRepository.save(f4);
		feedbacksRepository.save(f5);
	}

}