package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Matiere;

@CrossOrigin(origins="*")
public interface MatiereRepository extends JpaRepository<Matiere, String>{

}
