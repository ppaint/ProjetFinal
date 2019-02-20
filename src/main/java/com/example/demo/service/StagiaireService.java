package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Formation;
import com.example.demo.entity.Stagiaire;
import com.example.demo.repository.FormationRepository;
import com.example.demo.repository.StagiaireRepository;

@Service
public class StagiaireService {
	
	@Autowired
	private StagiaireRepository stagiaireRepository;
	
	@Autowired
	private FormationRepository formationRepository;
	
	public Stagiaire save(Stagiaire stagiaire) {
		if(stagiaire.getFormation() != null && !stagiaire.getFormation().equals("")) {
			Optional<Formation> opt = formationRepository.findById(stagiaire.getFormation().getId());
			if (opt.isPresent()) {
				Formation formationEnBase = opt.get();
				stagiaire.getFormation().setVersion(formationEnBase.getVersion());
				formationRepository.save(stagiaire.getFormation());
			} else {
				return null;
			}
	}
		return stagiaireRepository.save(stagiaire);
	}

}
