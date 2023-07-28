package com.SpringProject.assignment10;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User createUser(User user) throws IOException {
		user.setId(System.currentTimeMillis());
		return userRepository.save(user);
	}

	public User getUser(Long id) throws IOException, ClassNotFoundException {
		return userRepository.findById(id);
	}

	public List<User> getUsers() throws IOException, ClassNotFoundException {
		return userRepository.findAll();
	}

	public User updateUser(long id, User user) throws IOException {
		user.setId(id);
		return userRepository.save(user);
	}

	public boolean deletUser(long id) {
		userRepository.delet(id);
		return true;
	}
}