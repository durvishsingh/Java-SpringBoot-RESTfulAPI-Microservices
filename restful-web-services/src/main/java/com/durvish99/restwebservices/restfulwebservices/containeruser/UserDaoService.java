package com.durvish99.restwebservices.restfulwebservices.containeruser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class UserDaoService 
{
	private static List<User> users;
	private static int userCount;
	public UserDaoService()
	{
		userCount = 0;
		users = new ArrayList<User>();
		users.add(new User(++userCount, "Akki"));
		users.add(new User(++userCount, "Mini"));
		users.add(new User(++userCount, "Ginni"));
	}
	public List<User> getAllUsers()
	{
		return users;
	}
	public User getUser(int id) 
	{
		Predicate<? super User> predicate = user -> user.getId()==id;
		return users.stream().filter(predicate).findFirst().orElse(null);
		/*
		int n = users.size();
		for(int i=0;i<n;i++)
		{
			if(users.get(i).getId() == id)
			{
				return(users.get(i));
			}
		}
		return null;
		*/
	}
	public User creatUser(User user) 
	{
		User newUser = new User(++userCount, user.getName());
		users.add(newUser);
		return newUser;
	}
}
