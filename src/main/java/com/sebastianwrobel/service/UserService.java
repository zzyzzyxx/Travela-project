package com.sebastianwrobel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import com.sebastianwrobel.domain.Role;
import com.sebastianwrobel.domain.User;
import com.sebastianwrobel.repository.RoleRepository;
import com.sebastianwrobel.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	public void createNewAccount(User user) {
		user.setEnabled(true);
		user.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(user.getPassword()));
		userRepo.save(user);
		//creating CLIENT only at registration
		Role role = new Role();
		role.setLogin(user.getLogin());
		role.setRole("ROLE_CLIENT");
		roleRepo.save(role);
	}

	public Boolean loginExists(String login) {
		return userRepo.existsByLogin(login);
	}
}
