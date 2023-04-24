package com.igor.feedbacker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.igor.feedbacker.entities.Feedbacks;
import com.igor.feedbacker.entities.Pagination;
import com.igor.feedbacker.entities.Results;
import com.igor.feedbacker.entities.Users;
import com.igor.feedbacker.repositories.FeedbacksRepository;
import com.igor.feedbacker.repositories.PaginationRepository;
import com.igor.feedbacker.repositories.ResultsRepository;
import com.igor.feedbacker.repositories.UsersRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private FeedbacksRepository feedbacksRepository;
	
	@Autowired
	private PaginationRepository paginationRepo;
	
	@Autowired
	private ResultsRepository resultsRepo;
	
	PasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public void run(String... args) throws Exception {
		Users u1 = new Users("Doublas", "tesst@gmail.com", encoder.encode("123"), "ROLE_ADMIN");
		Feedbacks f1 = new Feedbacks(null, "idea", "texto","teste", null, "chrome", "pg1", u1 );
		Feedbacks f2 = new Feedbacks(null, "other", "texto","teste", null, "chrome", "pg1", u1 );
		Feedbacks f3 = new Feedbacks(null, "issue", "texto","teste", null, "chrome", "pg1", u1 );
		Feedbacks f4 = new Feedbacks(null, "issue", "texto","teste",null, "chrome", "pg1", u1 );
		Feedbacks f5 = new Feedbacks(null, "issue", "texto","teste", null, "chrome", "pg1", u1 );
		Pagination p1 = new Pagination(null, 0, 0, 5);
		// Results r1 = new Results(null, p1);
		
		userRepository.save(u1);
		feedbacksRepository.save(f1);
		feedbacksRepository.save(f2);
		feedbacksRepository.save(f3);
		feedbacksRepository.save(f4);
		feedbacksRepository.save(f5);
		//paginationRepo.save(p1);
		//resultsRepo.save(r1);
		
	}

}