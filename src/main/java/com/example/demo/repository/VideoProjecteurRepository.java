package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.VideoProjecteur;

@CrossOrigin(origins="*")
public interface VideoProjecteurRepository extends JpaRepository<VideoProjecteur, String>{

}
