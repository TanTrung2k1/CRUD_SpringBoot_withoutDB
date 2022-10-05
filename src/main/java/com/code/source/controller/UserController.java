package com.code.source.controller;

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

import com.code.source.model.User;
import com.code.source.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public List<User> getAllUser(){
		return service.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable("id") Long id){
		return service.getUserById(id);
	}
	
	@PostMapping("/users")
	public String addNewUser(@RequestBody User user) {
		User temp =  service.addNewUser(user);
		if(temp != null) {
			return "Add success";
		}else {
			return "Failed";
		}
	}
	
	@PutMapping("/users/{id}")
	public String updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		User temp =  service.updateUser(id, user);
		if(temp != null) {
			return "Update success";
		}else {
			return "Failed";
		}
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		boolean check = service.deleteUser(id);
		if(check == true) {
			return "Success";
		}else {
			return "Fail";
		}
	}
	
}
