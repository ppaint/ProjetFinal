package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.example.demo.entity.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Module {
	
	// ------------------ Attributs --------------------------- //

	@Id
	@JsonView(JsonViews.Common.class)
	private String titre;
	@JsonView(JsonViews.Common.class)
	private int duree;
	@JsonView(JsonViews.Common.class)
	private String objectif;
	@JsonView(JsonViews.Common.class)
	private String prerequis;
	@JsonView(JsonViews.Common.class)
	private String contenu;
	
	@JsonView(JsonViews.Matiere.class)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matiere")
	private Matiere matiere;
	
	@ManyToMany(mappedBy="modules", fetch = FetchType.LAZY)
	private Set<Formation> formations;
	
	@JsonView(JsonViews.Formateur.class)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "formateur")
	private Formateur formateur;
	
	@JsonView(JsonViews.Common.class)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "salle")
	private Salle salle;
	
	@Version
	private int version;
	
	
	// ------------------ Constructeurs --------------------------- //

		public Module() {
		super();
	}


	public Module(String titre, int duree, String objectif, String prerequis, String contenu) {
		super();
		this.titre = titre;
		this.duree = duree;
		this.objectif = objectif;
		this.prerequis = prerequis;
		this.contenu = contenu;
	}

	// ------------------ Methodes --------------------------- //

	public String getTitre() {
		return titre;
	}


	public Set<Formation> getFormations() {
		return formations;
	}


	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}


	public Formateur getFormateur() {
		return formateur;
	}


	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}


	public String getObjectif() {
		return objectif;
	}


	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}


	public String getPrerequis() {
		return prerequis;
	}


	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}


	public String getContenu() {
		return contenu;
	}


	public void setContenu(String contenu) {
		this.contenu = contenu;
	}


	public Salle getSalle() {
		return salle;
	}


	public void setSalle(Salle salle) {
		this.salle = salle;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}
	
	public Matiere getMatiere() {
		return matiere;
	}


	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contenu == null) ? 0 : contenu.hashCode());
		result = prime * result + duree;
		result = prime * result + ((objectif == null) ? 0 : objectif.hashCode());
		result = prime * result + ((prerequis == null) ? 0 : prerequis.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
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
		Module other = (Module) obj;
		if (contenu == null) {
			if (other.contenu != null)
				return false;
		} else if (!contenu.equals(other.contenu))
			return false;
		if (duree != other.duree)
			return false;
		if (objectif == null) {
			if (other.objectif != null)
				return false;
		} else if (!objectif.equals(other.objectif))
			return false;
		if (prerequis == null) {
			if (other.prerequis != null)
				return false;
		} else if (!prerequis.equals(other.prerequis))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}
		
	
	

}
