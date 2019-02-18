package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "formation")
public class Formation {
	
	@Id
	@Column(name = "formation_id")
	private String id;
	
	//Associations
	@ManyToMany
	@JoinTable(name="modules_formation", joinColumns= {@JoinColumn(name="titre")}, inverseJoinColumns= {@JoinColumn(name="id")})
	private Set<Module> modules;
	
	
	public Formation() {
		super();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Set<Module> getModules() {
		return modules;
	}


	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}
	
	

}
