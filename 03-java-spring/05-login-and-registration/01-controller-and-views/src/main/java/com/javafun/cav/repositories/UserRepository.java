package com.javafun.cav.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javafun.cav.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	User findByEmail(String subject);
}
