package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Matiere {
	// attributs propres à la matiere
	@Id
	@Column(name = "nom_matiere")
	private String nomMatiere;

	// associations

	@ManyToMany
	@JoinTable(name="modules_matieres", joinColumns= {@JoinColumn(name="titre")}, inverseJoinColumns= {@JoinColumn(name="nomMatiere")})
	private Set<Module> modules;

	public Matiere() {
		super();
	}

	public String getNomMatiere() {
		return nomMatiere;
	}
	
	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}

	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

}
