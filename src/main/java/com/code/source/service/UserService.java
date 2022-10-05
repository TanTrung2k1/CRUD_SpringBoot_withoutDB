package com.code.source.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.code.source.model.User;

@Service
public class UserService {
	private static Map<Long, User> listUser = new HashMap<>();
	private static Long index = 4L;
	
	static {
		User user_1 = new User(1L, "Trung", 21, "nguyentantrung1801@gmail.com", "0969920894");
		User user_2 = new User(2L, "Nam", 14, "nguyenthanhnam@gmail.com", "0123456789");
		User user_3 = new User(3L, "Thúy", 21, "nguyenthanhthuy@gmail.com", "0123456789");
		User user_4 = new User(4L, "Thảo", 21, "nguyenthanhthao@gmail.com", "0123456789");
		
		listUser.put(1L, user_1);
		listUser.put(2L, user_2);
		listUser.put(3L, user_3);
		listUser.put(4L, user_4);
	}
	
	
	
	public List<User> getAllUsers(){
		return new ArrayList<>(listUser.values());
	}
	
	public User getUserById(Long id) {
		return listUser.get(id);
	}
	
	public User addNewUser(User user) {
		index += 1;
		user.setId(index);
		listUser.put(index, user);
		return user;
	}
	
	
	public User updateUser(Long id, User user) {
		user.setId(id);
		listUser.put(id, user);
		return user;
	}
	
	public boolean deleteUser(Long id) {
		User user = listUser.get(id);
		if(user != null) {
			listUser.remove(id);
			return true;
		}
		return false;
		
	}

}
