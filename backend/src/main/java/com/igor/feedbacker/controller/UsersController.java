package com.igor.feedbacker.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

import com.igor.feedbacker.entities.Users;
import com.igor.feedbacker.services.UsersServiceImpl;

@RestController
@CrossOrigin
@RequestMapping(value = "/auth/register")
public class UsersController {
	
	@Autowired
	private UsersServiceImpl usersService;
	
	@GetMapping
	public ResponseEntity<List<Users>> allUsers(){
		List<Users> list = usersService.buscarTodos();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Users>> findById(@PathVariable UUID id){
		Optional<Users> user = usersService.buscaPorId(id);
		return ResponseEntity.ok().body(user);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id){
		usersService.deletarUsuario(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Users> newUser(@RequestBody Users obj) {
		Users user1 = usersService.novoUsuario(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user1.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
