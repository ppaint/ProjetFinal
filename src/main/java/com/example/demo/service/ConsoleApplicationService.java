package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class ConsoleApplicationService implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
//		List<User> users = userRepository.findAll();
//		for (User u : users) {
//			u.setPassword(passwordEncoder.encode(u.getUsername()));
//			userRepository.save(u);
//		}

	}

}
