package com.sebastianwrobel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sebastianwrobel.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	//we need to check if the user already exists
	//public Boolean existsByLogin(String login);
	
//	public User findByLogin(String login);
	
	
}