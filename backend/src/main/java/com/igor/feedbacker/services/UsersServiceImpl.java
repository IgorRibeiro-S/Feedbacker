package com.igor.feedbacker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.igor.feedbacker.entities.Users;
import com.igor.feedbacker.repositories.UsersRepository;
import com.igor.feedbacker.services.interfaces.SegurancaService;

@Service
public class UsersServiceImpl implements SegurancaService {

	@Autowired
	private UsersRepository repository;
	
	private PasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	@PreAuthorize("isAuthenticated()")
	public List<Users> findAll() {
		return repository.findAll();
	}

	@Override
	@PreAuthorize("isAuthenticated()")
	public Users findById(String id) {
		Optional<Users> obj = repository.findById(id);
		return obj.get();
	}

	@Override
	public Users insert(Users obj) {
		if (obj.getName() == null || obj.getName().trim().isEmpty() ||

				obj.getRoles() == null || obj.getRoles().trim().isEmpty()) {
			throw new IllegalArgumentException("Algum atributo em branco!");
		}
		obj.setPassword(encoder.encode(obj.getPassword()));
		return repository.save(obj);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

	public Users fromDto(Users pass) {
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = repository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
		return org.springframework.security.core.userdetails.User.builder().username(username)
				.password(user.getPassword()).authorities(user.getRoles()).build();
	}

	@Override
	public Users update(String id, Users obj) {
		return null;
	}


}
