package com.foy5.crud.business.abstracts;

import java.util.List;

import com.foy5.crud.entities.concretes.User;

public interface UserService {
	
	List<User> getAllUsers();
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(int userId);
	User getUserById(int userId);

}
