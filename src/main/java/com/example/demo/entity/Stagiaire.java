package com.example.demo.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "stagiaire")
@SequenceGenerator(name = "seqStagiaire", sequenceName = "seq_stagiaire", allocationSize = 1, initialValue = 100)
public abstract class Stagiaire {
	
	// ------------------ Attributs --------------------------- //
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqStagiaire")
	@Column(name = "stagiaire_number")
	private Long id;
	
	
	@Column(name = "last_name", length = 150, nullable = false)
	private String nom;
	
	
	@Column(name = "tel_number", length = 150, nullable = false)
	private String numeroTel;
	
	
	@Column(name = "fax_number", length = 150, nullable = false)
	private String numerofax;
	
	
	@Column(name = "mail", length = 150, nullable = false)
	private String email;
	
	
	@Autowired
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "pays", column = @Column(name = "country")),
			@AttributeOverride(name = "rue", column = @Column(name = "street", length = 150)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "zip_code", length = 5)),
			@AttributeOverride(name = "ville", column = @Column(name = "city", length = 150)) })
	private Adresse adresse;
	
	
	@Autowired
	@OneToOne
	private Login login;
	
	@Version
	private int version;
	
	// ------------------ Constructeurs --------------------------- //

	public Stagiaire() {
	}


	public Stagiaire(String nom, String numeroTel, String numerofax, String email, Adresse adresse) {
		super();
		this.nom = nom;
		this.numeroTel = numeroTel;
		this.numerofax = numerofax;
		this.email = email;
		this.adresse = adresse;
	}


	// ------------------ Methodes --------------------------- //

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getNumeroTel() {
		return numeroTel;
	}


	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}


	public String getNumerofax() {
		return numerofax;
	}


	public void setNumerofax(String numerofax) {
		this.numerofax = numerofax;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public void setVersion(int version) {
		this.version = version;
	}
}

	
