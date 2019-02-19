package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Module;

@CrossOrigin(origins="*")
public interface ModuleRepository extends JpaRepository<Module, String>{

}
