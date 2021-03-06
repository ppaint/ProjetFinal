package com.example.demo.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.entity.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "formation")
public class Formation {

	@Id
	@JsonView(JsonViews.Common.class)
	@Column(name = "formation_id")
	private String id;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonView(JsonViews.Common.class)
	private Date dateDebut;

	@JsonView(JsonViews.Common.class)
	private Integer duree;

	// Associations
	@JsonView(JsonViews.Module.class)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "modules_formation", joinColumns = { @JoinColumn(name = "titre") }, inverseJoinColumns = {
			@JoinColumn(name = "id") })
	private Set<Module> modules;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gestionnaire_id")
	private Gestionnaire gestionnaire;

	@JsonView(JsonViews.Module.class)
	@OneToMany(mappedBy = "formation", fetch = FetchType.LAZY)
	private List<Stagiaire> stagiaires;

	@Version
	private Integer version;

	public Formation() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}

	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
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
		Formation other = (Formation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
