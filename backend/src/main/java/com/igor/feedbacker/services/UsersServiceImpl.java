package com.igor.feedbacker.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor.feedbacker.entities.Users;
import com.igor.feedbacker.repositories.UsersRepository;
import com.igor.feedbacker.services.interfaces.UsersServicesInterface;

@Service
public class UsersServiceImpl implements UsersServicesInterface {

	@Autowired
	private UsersRepository usersRepo;
	
	@Override
	public List<Users> buscarTodos() {
		return usersRepo.findAll();
	}

	@Override
	public Users novoUsuario(Users obj) {
		Users usr = usersRepo.save(obj);
		return usersRepo.save(usr);
	}

	@Override
	public void deletarUsuario(UUID id) {
		buscaPorId(id);
		usersRepo.deleteById(id);
		
	}

	@Override
	public Optional<Users> buscaPorId(UUID id) {
		Optional<Users> obj = usersRepo.findById(id);
		return obj;
	}

}
