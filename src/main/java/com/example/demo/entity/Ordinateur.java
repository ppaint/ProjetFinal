package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ordinateur")
@SequenceGenerator(name = "seqOrdinateur", sequenceName = "seq_ordinateur", allocationSize = 1, initialValue = 100)
public class Ordinateur {
	//Attributs généraux
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqOrdinateur")
	@Column(name = "ordinateur_code")
	private String code;
	
	@Column(name="ordinateur_cout")
	private Long cout;
	
	@Column(name="ordinateur_indispo")
	private ArrayList<Date> dates;
		
	//Attributs propres à Ordinateur
	@Column(name = "processeur")
	private String processeur;
	
	@Column(name = "ram")
	private Integer ram;
	
	@Column(name = "disque_dur")
	private Integer dd;
	
	@Column(name = "annee")
	private Integer annee;
	
	//Relations avec d'autres entités
	@OneToOne
	private Stagiaire stagiaire;
	
	@OneToOne
	private Technicien technicien;
	
	
	public Ordinateur() {
		super();
	}
	
	public String getCode() {
		return code;
	}


	public Long getCout() {
		return cout;
	}

	public void setCout(Long cout) {
		this.cout = cout;
	}

	public ArrayList<Date> getDates() {
		return dates;
	}

	public void setDates(ArrayList<Date> dates) {
		this.dates = dates;
	}

	public String getProcesseur() {
		return processeur;
	}

	public void setProcesseur(String processeur) {
		this.processeur = processeur;
	}

	public Integer getRam() {
		return ram;
	}

	public void setRam(Integer ram) {
		this.ram = ram;
	}

	public Integer getDd() {
		return dd;
	}

	public void setDd(Integer dd) {
		this.dd = dd;
	}

	public Integer getAnnee() {
		return annee;
	}

	public void setAnnee(Integer annee) {
		this.annee = annee;
	}
	
	
	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	public Technicien getTechnicien() {
		return technicien;
	}

	public void setTechnicien(Technicien technicien) {
		this.technicien = technicien;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		Ordinateur other = (Ordinateur) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	
	
}
