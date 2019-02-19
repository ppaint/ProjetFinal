package com.example.demo.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.example.demo.entity.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "stagiaire")
@SequenceGenerator(name = "seqStagiaire", sequenceName = "seq_stagiaire", allocationSize = 1, initialValue = 100)
public class Stagiaire {
	
	// ------------------ Attributs --------------------------- //
	
	@Id
	@JsonView(JsonViews.Common.class)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqStagiaire")
	@Column(name = "stagiaire_number")
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

	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "number")),
			@AttributeOverride(name = "rue", column = @Column(name = "street", length = 150)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "zip_code", length = 5)),
			@AttributeOverride(name = "ville", column = @Column(name = "city", length = 150)) })
	private Adresse adresse;

	@JsonView(JsonViews.Common.class)
	@OneToOne(fetch = FetchType.LAZY)
	private Ordinateur ordinateur;
	
	@OneToOne
	private Login login;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="formation")
	private Formation formation;
	
	@Version
	private int version;
	
	// ------------------ Constructeurs --------------------------- //

	public Stagiaire() {
	}

	public Stagiaire(String prenom, String nom, Coordonnees coordonnees, Adresse adresse) {
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


	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}


	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}
}

	
