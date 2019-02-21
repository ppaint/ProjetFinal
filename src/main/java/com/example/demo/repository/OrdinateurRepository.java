package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Ordinateur;

@CrossOrigin(origins="*")
public interface OrdinateurRepository extends JpaRepository<Ordinateur, String> {
	
	@Query("select o from Ordinateur o left join fetch o.stagiaire s where s.ordinateur IS NULL")
	public Optional<List<Ordinateur>> findByOrdinateurWithNostagiaire();

}
