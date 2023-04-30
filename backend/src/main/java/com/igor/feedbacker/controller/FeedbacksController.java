package com.igor.feedbacker.controller;

import java.net.URI;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.igor.feedbacker.entities.Feedbacks;
import com.igor.feedbacker.entities.Users;
import com.igor.feedbacker.repositories.FeedbacksRepository;
import com.igor.feedbacker.repositories.UsersRepository;
import com.igor.feedbacker.services.FeedbacksServiceImpl;
import com.igor.feedbacker.services.UsersServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@CrossOrigin
@RequestMapping(value = "/feedbacks")
public class FeedbacksController {

	@Autowired
	private FeedbacksServiceImpl feedbackssService;

	@Autowired
	private UsersServiceImpl service;

	@Autowired
	private UsersRepository repo;

	@Autowired
	private FeedbacksRepository feedbackRepo;

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping
	public ResponseEntity<?> allFeedbacksById(Authentication auth, Principal principal) {
		Users usr = repo.findByEmail(auth.getName());
		
		Map<String, Object> list = feedbackssService.buscarTodosPorId(usr.getId());
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(value = "/{id}")
	public ResponseEntity<Feedbacks> findById(@PathVariable String id) {
		Optional<Feedbacks> feedbacks = feedbackssService.buscaPorId(id);
		return ResponseEntity.ok().body(feedbacks.get());
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(value = "/type")
	public ResponseEntity<?> findByType(@RequestParam String type, Authentication auth, Principal principal) {
		Users usr = repo.findByEmail(auth.getName());
		Map<String, Object> list = feedbackssService.buscarPorTipo(type, usr.getId());
		return ResponseEntity.ok().body(list);
	}

	@PreAuthorize("isAuthenticated()")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(value = "/summary")
	public ResponseEntity<HashMap<String, Integer>> findFeedbacksSummary(Authentication auth, Principal principal) {
		HashMap<String, Integer> example = new HashMap<>();
		Users usr = repo.findByEmail(auth.getName());
		List<String> types = new ArrayList<>();
		List<Feedbacks> list = feedbackRepo.findByUserId(usr.getId());

		int issue = 0;
		int idea = 0;
		int other = 0;

		for (Feedbacks c : list) {
			types.add(c.getType());
			if (c.getType().equals("other") || c.getType().equals("OTHER")) {
				other++;
			}
			if (c.getType().equals("issue") || c.getType().equals("ISSUE")) {
				issue++;
			}
			if (c.getType().equals("idea") || c.getType().equals("IDEA")) {
				idea++;
			}
		}
		example.put("all", types.size());
		example.put("issue", issue);
		example.put("idea", idea);
		example.put("other", other);

		return ResponseEntity.ok().body(example);
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		feedbackssService.deletarFeedback(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<Feedbacks> newFeedback(@RequestBody Feedbacks obj) {
		obj.setIdUser(repo.findByApiKey(obj.getApiKey()).getId());
		Users us1 = service.findById(obj.getIdUser());
		obj.setApiKey(us1.getApiKey());
		obj.setUser(us1);
		Feedbacks feedbacks1 = feedbackssService.novoFeedback(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(feedbacks1.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

}
