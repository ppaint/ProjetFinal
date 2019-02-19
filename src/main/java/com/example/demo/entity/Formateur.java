package com.example.demo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "formateur")
@SequenceGenerator(name = "seqFormateur", sequenceName = "seq_formateur", allocationSize = 1, initialValue = 100)
public class Formateur {
	
	// ------------------ Attributs --------------------------- //
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFormateur")
	@Column(name = "formateur_number")
	private Integer id;
	
	
	@Column(name = "first_name", length = 150, nullable = false)
	private String prenom;
	
	
	@Column(name = "last_name", length = 150, nullable = false)
	private String nom;
	
	
	@Autowired
	@Embedded
	@Column(name = "coordonnees", length = 150)
	private Coordonnees coordonnees;
	
	@OneToMany(mappedBy = "formateur")
	private List<Module> modules;
	
	
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
	
	@ManyToMany(mappedBy="formateurs")
	private Set<Matiere> matieres;
	
	@Version
	private int version;
	
	
	
	// ------------------ Constructeurs --------------------------- //

	public Formateur() {
	}

	public Formateur(String prenom, String nom, Coordonnees coordonnees, Adresse adresse) {
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


	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public Set<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
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
		Formateur other = (Formateur) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

	
