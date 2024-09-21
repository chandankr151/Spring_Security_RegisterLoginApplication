package com.chandan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandan.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByEmail(String email);
}
