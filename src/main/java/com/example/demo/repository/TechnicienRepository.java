package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Technicien;

public interface TechnicienRepository extends JpaRepository<Technicien, Integer> {

}
