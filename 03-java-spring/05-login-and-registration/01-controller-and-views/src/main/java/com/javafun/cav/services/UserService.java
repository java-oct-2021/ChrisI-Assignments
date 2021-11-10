package com.javafun.cav.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafun.cav.models.User;
import com.javafun.cav.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	public User add (User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
	}
	
	public User getById(Long userId) {
		return userRepo.findById(userId).get();
	}
	
	public User getByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public boolean authenticatUser(String email, String password) {
		User user = userRepo.findByEmail(email);
		
		if(user == null) {
			System.out.println("user dne");
			return false;
		} else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				System.out.println("authenticated!");
				return true;
			} else {
				System.out.println("not authenticated!");
				return false;
			}
		}
	}
}
