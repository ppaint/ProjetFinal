package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "formation")
@SequenceGenerator(name = "seqFormation", sequenceName = "seq_formation", allocationSize = 1, initialValue = 100)
public class Formation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFormation")
	@Column(name = "formation_number")
	private Long id;

	public Formation() {
		super();
	}
	
	

}
