package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Module;

@CrossOrigin(origins="*")
public interface ModuleRepository extends JpaRepository<Module, String>{
	
	@Query("select m from Module m left join fetch m.formations where m.titre = ?1")
	public Optional<Module> findByIdWithFormations(String id);


}
