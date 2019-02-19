package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Ordinateur;

@CrossOrigin(origins="*")
public interface OrdinateurRepository extends JpaRepository<Ordinateur, String> {

}
