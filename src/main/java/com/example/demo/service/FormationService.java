package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Formation;
import com.example.demo.entity.Module;
import com.example.demo.entity.Stagiaire;
import com.example.demo.repository.FormationRepository;
import com.example.demo.repository.ModuleRepository;
import com.example.demo.repository.StagiaireRepository;

@Service
public class FormationService {
	@Autowired
	private FormationRepository formationRepository;

	@Autowired
	private StagiaireRepository stagiaireRepository;
	
	@Autowired
	private ModuleRepository moduleRepository;

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
			if (!formationRepository.findById(id).get().getStagiaires().isEmpty()) {
				for (Stagiaire s : formationRepository.findById(id).get().getStagiaires()) {
					s.setFormation(null);
					stagiaireRepository.save(s);
				}
			}
			formationRepository.deleteById(id);
		}
	}
	
	public Formation save(Formation formation) {
		if (formation.getModules() != null) {
			for(Module m: formation.getModules()) {
				Module moduleEnBase = moduleRepository.findById(m.getTitre()).get();
				m.setVersion(moduleEnBase.getVersion());
				m = moduleRepository.save(m);
			}
		}
		return formation;
	}
}
