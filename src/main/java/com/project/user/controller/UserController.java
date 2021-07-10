package com.project.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.user.model.User;
import com.project.user.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/user")
	private List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/user/{userid}")
	private User getUsers(@PathVariable("userid") int userid) {
		return userService.getUsersById(userid);
	}

	@DeleteMapping("/user/{userid}")
	private void deleteUser(@PathVariable("userid") int userid) {
		userService.delete(userid);
	}

	@PostMapping("/users")
	private int saveUser(@RequestBody User users) {
		userService.saveOrUpdate(users);
		return users.getId();
	}

	@PutMapping("/users")
	private User update(@RequestBody User users) {
		userService.saveOrUpdate(users);
		return users;
	}
}