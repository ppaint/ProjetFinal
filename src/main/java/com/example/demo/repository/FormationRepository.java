package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Formation;

@CrossOrigin(origins="*")
public interface FormationRepository extends JpaRepository<Formation, String>{
	
	@Query("select f from Formation f left join fetch f.stagiaires s where f.id = ?1")
	public Optional<Formation> findByIdWithStagiaire(String id);
}
