package com.example.demo.entity;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.example.demo.entity.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "gestionnaire")
@SequenceGenerator(name = "seqGestionnaire", sequenceName = "seq_gestionnaire", allocationSize = 1, initialValue = 100)
public class Gestionnaire {
	
	// ------------------ Attributs --------------------------- //
	
	@Id
	@JsonView(JsonViews.Common.class)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGestionnaire")
	@Column(name = "gestionnaire_number")
	private Integer id;
	
	
	@JsonView(JsonViews.Common.class)
	@Column(name = "first_name", length = 150, nullable = false)
	private String prenom;
	
	
	@JsonView(JsonViews.Common.class)
	@Column(name = "last_name", length = 150, nullable = false)
	private String nom;
	
	
	@Embedded
	@Column(name = "coordonnees", length = 150)
	private Coordonnees coordonnees;
	
	@JsonView(JsonViews.Common.class)
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "number")),
			@AttributeOverride(name = "rue", column = @Column(name = "street", length = 150)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "zip_code", length = 5)),
			@AttributeOverride(name = "ville", column = @Column(name = "city", length = 150)) })
	private Adresse adresse;
	

	@OneToOne
	private Login login;
	
	@Version
	private int version;
	
	@JsonView(JsonViews.Formation.class)
	@OneToMany(mappedBy = "gestionnaire", fetch = FetchType.LAZY)
	private Set<Formation> formations;
	
	// ------------------ Constructeurs --------------------------- //

	public Gestionnaire() {
	}

	public Gestionnaire(String prenom, String nom, Coordonnees coordonnees, Adresse adresse) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.coordonnees = coordonnees;
		this.adresse = adresse;
	}




	// ------------------ Methodes --------------------------- //

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}


	public int getVersion() {
		return version;
	}


	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

	public void setVersion(int version) {
		this.version = version;
	}

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
		Gestionnaire other = (Gestionnaire) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

	
