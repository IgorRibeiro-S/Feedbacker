package com.igor.feedbacker.services.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.igor.feedbacker.entities.Users;

public interface UsersServicesInterface {
	
	public List<Users> buscarTodos();
	public Users novoUsuario(Users obj);
	public void deletarUsuario(UUID id);
	public Optional<Users> buscaPorId(UUID id);
}
