package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Stagiaire;

@CrossOrigin(origins="*")
public interface StagiaireRepository extends JpaRepository<Stagiaire, Integer> {

}
