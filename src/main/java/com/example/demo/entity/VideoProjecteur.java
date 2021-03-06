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
@Table(name = "videoprojecteur")
public class VideoProjecteur {

	// Attributs généraux
	@Id
	@Column(name = "videoproj_code")
	private String code;

	@Column(name = "videoproj_cout")
	private Long cout;

	@Column(name = "videoproj_indispo")
	private ArrayList<Date> dates;
	
	
	//Relations avec les autres entités
	@OneToOne(fetch = FetchType.LAZY)
	private Salle salle;
	
	
	public VideoProjecteur() {
		super();
	}
	
	public String getCode() {
		return code;
	}

	
	public void setCode(String code) {
		this.code = code;
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
