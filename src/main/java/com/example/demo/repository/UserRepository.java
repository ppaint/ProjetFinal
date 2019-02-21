package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	@Query("select u from User u left join fetch u.roles where u.username=?1")
	public Optional<User> findByIdWithRoles(String username);
}
