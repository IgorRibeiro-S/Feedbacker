package com.igor.feedbacker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.igor.feedbacker.entities.Feedbacks;
import com.igor.feedbacker.repositories.FeedbacksRepository;
import com.igor.feedbacker.services.interfaces.FeedbacksServicesInterface;

@Service
public class FeedbacksServiceImpl implements FeedbacksServicesInterface {

	@Autowired
	private FeedbacksRepository feedbacksRepo;
	
	
	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public List<Feedbacks> buscarTodos() {
		return feedbacksRepo.findAll();
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Feedbacks novoFeedback(Feedbacks obj) {;
		Feedbacks usr = feedbacksRepo.save(obj);
		return feedbacksRepo.save(usr);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public void deletarFeedback(String id) {
		buscaPorId(id);
		feedbacksRepo.deleteById(id);
		
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Optional<Feedbacks> buscaPorId(String id) {
		Optional<Feedbacks> obj = feedbacksRepo.findById(id);
		return obj;
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Feedbacks> buscarPorTipo(String tipo) {
		return feedbacksRepo.findByTypeContains(tipo);
	}

}
