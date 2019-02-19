package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Formation;
import com.example.demo.entity.Stagiaire;
import com.example.demo.repository.FormationRepository;

@Service
public class FormationService {
	@Autowired
	private FormationRepository formationRepository;

	public void delete(Formation formation) {
		if (formation.getStagiaires() != null) {
			for (Stagiaire s : formation.getStagiaires()) {
				System.out.println(s);
				// s.setFormation(null);
			}
		}
		formationRepository.delete(formation);
	}

}
