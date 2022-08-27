package com.durvish99.restwebservices.restfulwebservices.containeruser;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController 
{
	@Autowired
	private UserDaoService daoService;
	
	public UserController(UserDaoService daoService)
	{
		this.daoService = daoService;
	}
	
	@GetMapping(path = "/users")
	public List<User> getUsers()
	{
		return daoService.getAllUsers();
	}
	
	@GetMapping(path = "/users/{id}")
	public User getUserById(@PathVariable int id)
	{
		User user = daoService.getUser(id);
		if(user == null)
		{
			throw new NotFoundException("Element not found : "+id);
		}
		return user;
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<Object> getUserById(@RequestBody User user)
	{
		User newUser = daoService.creatUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").
				buildAndExpand(newUser.getId()).
				toUri();
		
		return ResponseEntity.created(location).build();
	}
}
