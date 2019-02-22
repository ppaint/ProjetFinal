package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Formation;
import com.example.demo.entity.Module;
import com.example.demo.repository.FormationRepository;
import com.example.demo.repository.ModuleRepository;

@Service
public class ModuleService {
	
	@Autowired
	private ModuleRepository moduleRepository;
	
	@Autowired
	private FormationRepository formationRepository;
	
	public void delete(Module module) {
		if (module.getFormations() != null) {
			for (Formation f : module.getFormations()) {
				f.getModules().remove(module);
				formationRepository.save(f);
			}
		}
		moduleRepository.delete(module);
	}

	public void deleteById(String titre) {
		if (moduleRepository.findById(titre).isPresent()) {
			if (moduleRepository.findById(titre).get().getFormations() != null) {
				for (Formation f : moduleRepository.findById(titre).get().getFormations()) {
					f.getModules().remove(moduleRepository.findById(titre).get());
					formationRepository.save(f);
				}
			}
			moduleRepository.deleteById(titre);
		}
	}

	public void deleteOfFormation(String IdFormation, String titreModule) {
		if (formationRepository.findByIdWithModules(IdFormation).isPresent()) {
			if (formationRepository.findByIdWithModules(IdFormation).get().getModules() != null) {
				Formation formationEnBase = formationRepository.findByIdWithModules(IdFormation).get();
				formationEnBase.getModules().remove(moduleRepository.findById(titreModule).get());
				formationEnBase = formationRepository.save(formationEnBase);
			}
		}		
	}

}
