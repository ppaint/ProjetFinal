package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Salle;

@CrossOrigin(origins="*")
public interface SalleRepository extends JpaRepository<Salle, String>{
	
}
