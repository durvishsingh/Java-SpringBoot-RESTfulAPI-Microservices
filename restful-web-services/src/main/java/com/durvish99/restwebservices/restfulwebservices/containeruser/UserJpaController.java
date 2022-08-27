package com.durvish99.restwebservices.restfulwebservices.containeruser;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.durvish99.restwebservices.restfulwebservices.jpa.UserRepository;

@RestController
public class UserJpaController 
{
	private UserDaoService daoService;
	private UserRepository repository;
	
	public UserJpaController(UserDaoService daoService, UserRepository repository)
	{
		this.repository = repository;
		this.daoService = daoService;
	}
	
	@GetMapping(path = "/jpa/users")
	public List<User> getUsers()
	{
		return repository.findAll();
	}
	
	@GetMapping(path = "/jpa/users/{id}")
	public User getUserById(@PathVariable int id)
	{
		Optional<User> user = repository.findById(id);
		if(user.isEmpty())
		{
			throw new NotFoundException("Element not found : "+id);
		}
		return user.get();
	}
	
	@PostMapping(path = "/jpa/users")
	public ResponseEntity<Object> getUserById(@RequestBody User user)
	{
		User newUser = repository.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").
				buildAndExpand(newUser.getId()).
				toUri();
		
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUserById(@PathVariable int id)
	{
		repository.deleteById(id);
	}
}
