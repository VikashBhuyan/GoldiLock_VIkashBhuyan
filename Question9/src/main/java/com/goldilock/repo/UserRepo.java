package com.goldilock.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goldilock.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
