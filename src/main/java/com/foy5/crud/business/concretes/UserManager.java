package com.foy5.crud.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foy5.crud.business.abstracts.UserService;
import com.foy5.crud.entities.concretes.User;
import com.foy5.crud.repository.abstracts.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements UserService{
	
	private UserRepository userRepository;
		
	@Override
	public List<User> getAllUsers() {
		
		List<User> users = userRepository.findAll();
		
		return users;
	}

	@Override
	public void addUser(User user) {
		
		this.userRepository.save(user);
		
	}

	@Override
	public void updateUser(User user) {
		
		User tempUser = userRepository.findById(user.getId()).orElseThrow();
		
		tempUser.setFirstName(user.getFirstName());
		tempUser.setLastName(user.getLastName());
		tempUser.setEmail(user.getEmail());
		
		userRepository.save(tempUser);
		
		
	}

	@Override
	public void deleteUser(int userId) {

		userRepository.deleteById(userId);
		
	}

	@Override
	public User getUserById(int userId) {
		
		User user = userRepository.findById(userId).orElseThrow();
		
		return user;
		
	}

}
