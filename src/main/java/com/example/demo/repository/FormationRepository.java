package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Formation;

@CrossOrigin(origins="*")
public interface FormationRepository extends JpaRepository<Formation, String>{

}
