package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.entity.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "ordinateur")
public class Ordinateur {
	//Attributs généraux
	@Id
	@JsonView(JsonViews.Common.class)
	@Column(name = "ordinateur_code")
	private String code;
	
	@JsonView(JsonViews.Common.class)
	@Column(name="ordinateur_cout")
	private Long cout;
	
	@JsonView(JsonViews.Common.class)
	@Column(name="ordinateur_indispo")
	private ArrayList<Date> dates;
		
	//Attributs propres à Ordinateur
	@JsonView(JsonViews.Common.class)
	@Column(name = "processeur")
	private String processeur;
	
	@JsonView(JsonViews.Common.class)
	@Column(name = "ram")
	private Integer ram;
	
	@JsonView(JsonViews.Common.class)
	@Column(name = "disque_dur")
	private Integer dd;
	
	@JsonView(JsonViews.Common.class)
	@Column(name = "annee")
	private Integer annee;
	
	//Relations avec d'autres entités
	@OneToOne(mappedBy = "ordinateur", fetch = FetchType.LAZY)
	private Stagiaire stagiaire;
	
	
	public Ordinateur() {
		super();
	}
	
	public String getCode() {
		return code;
	}


	public Long getCout() {
		return cout;
	}

	public void setCode(String code) {
		this.code = code;
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
