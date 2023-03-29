package com.igor.feedbacker.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.igor.feedbacker.entities.Users;
import com.igor.feedbacker.security.JwtUtils;
import com.igor.feedbacker.security.Login;
import com.igor.feedbacker.services.UsersServiceImpl;
import com.igor.feedbacker.utils.RandomString;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/auth")
public class AuthController {
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UsersServiceImpl usersService;

	@ApiOperation(value = "", authorizations = { @Authorization(value="Bearer") })
	@GetMapping
	public ResponseEntity<List<Users>> allUsers() {
		List<Users> list = usersService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "", authorizations = { @Authorization(value="Bearer") })
	@GetMapping(value = "/{id}")
	public ResponseEntity<Users> findById(@PathVariable String id) {
		Users user = usersService.findById(id);
		return ResponseEntity.ok().body(user);
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value="Bearer") })
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		usersService.delete(id);
		return ResponseEntity.noContent().build();
	}
	@ApiOperation(value = "Novo Usuário")
	@PostMapping(value = "/register")
	public ResponseEntity<Users> newUser(@RequestBody Users obj) {
		obj.setApiKey(RandomString.getAlphaNumericString(32));
		obj.setCreatedAt(LocalDateTime.now());
		Users user1 = usersService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user1.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "", authorizations = { @Authorization(value="Bearer") })
	@PostMapping(value = "/login")
	public Login autenticar(@RequestBody Login login) throws JsonProcessingException {
		Authentication auth = new UsernamePasswordAuthenticationToken(login.getName(), login.getSenha());
		auth = authManager.authenticate(auth);
		login.setSenha(null);
		login.setToken(JwtUtils.generateToken(auth));
		login.setAutorizacao(auth.getAuthorities().iterator().next().getAuthority());
		return login;
	}

}
