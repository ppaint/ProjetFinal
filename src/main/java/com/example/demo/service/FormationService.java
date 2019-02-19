package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Formation;
import com.example.demo.entity.Stagiaire;
import com.example.demo.repository.FormationRepository;
import com.example.demo.repository.StagiaireRepository;

@Service
public class FormationService {
	@Autowired
	private FormationRepository formationRepository;

	@Autowired
	private StagiaireRepository stagiaireRepository;

	public void delete(Formation formation) {
		if (formation.getStagiaires() != null) {
			for (Stagiaire s : formation.getStagiaires()) {
				s.setFormation(null);
				stagiaireRepository.save(s);
			}
		}
		formationRepository.delete(formation);
	}

	public void deleteById(String id) {

		if (formationRepository.findById(id).isPresent()) {
			if (formationRepository.findById(id).get().getStagiaires() != null) {
				for (Stagiaire s : formationRepository.findById(id).get().getStagiaires()) {
					s.setFormation(null);
					stagiaireRepository.save(s);
				}
			}
			formationRepository.deleteById(id);
		}
	}
}
