package com.teligen.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teligen.sample.domain.User;

public interface UserJPARepository extends JpaRepository<User, Long> {

	User findById(Long id);
	
	Long deleteByUsername(String username);
	
	Long countByUsername(String username);
	
	List<User> findByUsername(String username);
}