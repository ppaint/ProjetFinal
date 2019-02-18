package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Gestionnaire;

public interface GestionnaireRepository extends JpaRepository<Gestionnaire, Integer> {

}
