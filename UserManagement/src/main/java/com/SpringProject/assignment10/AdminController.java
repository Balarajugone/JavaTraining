package com.SpringProject.assignment10;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;

	
	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) throws IOException, ClassNotFoundException {
		return userService.getUser(id);
	}

	@GetMapping
	public List<User> getUsers() throws IOException, ClassNotFoundException {
		return userService.getUsers();
	}

	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable long id) throws IOException {
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping("/{id}")
	public boolean deletUser(@PathVariable long id) throws IOException {
		return userService.deletUser(id);
	}

}
