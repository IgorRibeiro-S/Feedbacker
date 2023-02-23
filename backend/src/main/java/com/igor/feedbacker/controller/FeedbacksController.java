package com.igor.feedbacker.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.igor.feedbacker.entities.Feedbacks;
import com.igor.feedbacker.services.FeedbacksServiceImpl;

@RestController
@CrossOrigin
@RequestMapping(value = "/feedbacks")
public class FeedbacksController {
	
	@Autowired
	private FeedbacksServiceImpl feedbackssService;
	
	@GetMapping
	public ResponseEntity<List<Feedbacks>> allFeedbacks(){
		List<Feedbacks> list = feedbackssService.buscarTodos();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Feedbacks> findById(@PathVariable String id){
		Optional<Feedbacks> feedbacks = feedbackssService.buscaPorId(id);
		return ResponseEntity.ok().body(feedbacks.get());
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		feedbackssService.deletarFeedback(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Feedbacks> newFeedback(@RequestBody Feedbacks obj) {
		Feedbacks feedbacks1 = feedbackssService.novoFeedback(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(feedbacks1.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
