package com.durvish99.restwebservices.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durvish99.restwebservices.restfulwebservices.containeruser.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
	
}
