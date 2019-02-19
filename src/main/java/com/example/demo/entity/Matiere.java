package com.example.demo.entity;

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
	
	@ManyToMany
	@JoinTable(name="formateurs_matieres", joinColumns= {@JoinColumn(name="id")}, inverseJoinColumns= {@JoinColumn(name="nomMatiere")})
		private Set<Formateur> formateurs;

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

	public Set<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(Set<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomMatiere == null) ? 0 : nomMatiere.hashCode());
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
		Matiere other = (Matiere) obj;
		if (nomMatiere == null) {
			if (other.nomMatiere != null)
				return false;
		} else if (!nomMatiere.equals(other.nomMatiere))
			return false;
		return true;
	}
	

}
