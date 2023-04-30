package com.igor.feedbacker.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igor.feedbacker.entities.Users;
import com.igor.feedbacker.repositories.UsersRepository;
import com.igor.feedbacker.utils.RandomString;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@CrossOrigin
@RequestMapping(value = "/user/me")
public class UsersController {

	@Autowired
	private UsersRepository repo;

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping
	public ResponseEntity<Users> findByMe(Authentication auth, Principal principal) {
		return ResponseEntity.ok().body(repo.findByEmail(auth.getName()));

	}

	@ApiOperation(value = "", authorizations = { @Authorization(value = "Bearer") })
	@PostMapping(value = "/apikey")
	public ResponseEntity<String> newApiKey(Authentication auth, Principal principal) {
		Users usr = repo.findByEmail(auth.getName());
		String apiKey = RandomString.getAlphaNumericString(30);
		usr.setApiKey(apiKey);
		repo.save(usr);
		return ResponseEntity.ok().body(apiKey);
	}

	@RequestMapping(value= "/apikey/exists", method = {RequestMethod.GET, RequestMethod.HEAD})
	public ResponseEntity<String> apiExists(@RequestParam String id) {
		if (repo.findById(id) != null) {
			return ResponseEntity.ok().body("ok");

		}
		return ResponseEntity.badRequest().body("nenhum Id encontrado");
	}

}
