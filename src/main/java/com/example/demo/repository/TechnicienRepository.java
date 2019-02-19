package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Technicien;

@CrossOrigin(origins="*")
public interface TechnicienRepository extends JpaRepository<Technicien, Integer> {

}
