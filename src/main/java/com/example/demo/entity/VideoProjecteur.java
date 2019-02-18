package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "videoprojecteur")
@SequenceGenerator(name = "seqVideoproj", sequenceName = "seq_videoproj", allocationSize = 1, initialValue = 100)
public class VideoProjecteur {

	// Attributs généraux
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVideoproj")
	@Column(name = "videoproj_code")
	private String code;

	@Column(name = "videoproj_cout")
	private Long cout;

	@Column(name = "videoproj_indispo")
	private ArrayList<Date> dates;
	
	
	//Relations avec les autres entités
	@OneToOne
	private Salle salle;
	
	@ManyToOne
	private Technicien technicien;
	
	public VideoProjecteur() {
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

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
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
		VideoProjecteur other = (VideoProjecteur) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	
}
