package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Formateur;

@CrossOrigin(origins="*")
public interface FormateurRepository extends JpaRepository<Formateur, Integer> {

}
