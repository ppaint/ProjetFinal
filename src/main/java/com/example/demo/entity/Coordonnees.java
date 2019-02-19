package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.stereotype.Component;

@Embeddable
public class Coordonnees {
	@Column(name = "numero_telephone", length = 200)
	private String tel;
	@Column(name = "fax", length = 200)
	private String fax;
	@Column(name = "adresse_mail", length = 5)
	private String mail;

	public Coordonnees() {
	}

	public Coordonnees(String tel, String fax, String mail) {
		super();
		this.tel = tel;
		this.fax = fax;
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		Coordonnees other = (Coordonnees) obj;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
}