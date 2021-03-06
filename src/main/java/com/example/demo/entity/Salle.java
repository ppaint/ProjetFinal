package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salle")
public class Salle {
	// Attributs généraux
	@Id
	@Column(name = "salle_code")
	private String code;

	@Column(name = "salle_cout")
	private Long cout;

	@Column(name = "salle_indispo")
	private ArrayList<Date> dates;

	// Liens et associations avec autres entités
	@OneToOne(mappedBy = "salle", fetch = FetchType.LAZY)
	private VideoProjecteur videoProjecteur;

	@OneToOne(mappedBy = "salle", fetch = FetchType.LAZY)
	private Module module;

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

	public VideoProjecteur getVideoProjecteur() {
		return videoProjecteur;
	}

	public void setVideoProjecteur(VideoProjecteur videoProjecteur) {
		this.videoProjecteur = videoProjecteur;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
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
		Salle other = (Salle) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

}
