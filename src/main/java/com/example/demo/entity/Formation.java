package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name="gestionnaire_id")
	private Gestionnaire gestionnaire;
	
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


<<<<<<< HEAD
	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}


	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}


=======
>>>>>>> a3ce35422c3224ce310430bb946c9dec8c8511bf
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formation other = (Formation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
<<<<<<< HEAD
=======
	
>>>>>>> a3ce35422c3224ce310430bb946c9dec8c8511bf
	
	

}
