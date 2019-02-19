package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Gestionnaire;

@CrossOrigin(origins="*")
public interface GestionnaireRepository extends JpaRepository<Gestionnaire, Integer> {

}
