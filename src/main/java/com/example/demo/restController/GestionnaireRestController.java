package com.example.demo.restController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.entity.Formation;
import com.example.demo.entity.Gestionnaire;
import com.example.demo.entity.jsonview.JsonViews;
import com.example.demo.repository.FormationRepository;
import com.example.demo.repository.GestionnaireRepository;
import com.example.demo.service.FormationService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/rest/gestionnaire")
public class GestionnaireRestController {

	@Autowired
	private GestionnaireRepository gestionnaireRepository;
	
	@Autowired
	private FormationRepository formationRepository;
	
	@Autowired
	private FormationService formationService;


	@JsonView(JsonViews.Common.class)
	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<Gestionnaire>> findAllGestionnaire() {
		return new ResponseEntity<List<Gestionnaire>>(gestionnaireRepository.findAll(), HttpStatus.OK);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public ResponseEntity<Gestionnaire> findById(@PathVariable(name = "id") Integer id) {
		Optional<Gestionnaire> opt = gestionnaireRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Gestionnaire>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@JsonView(JsonViews.Formation.class)
	@GetMapping("/formation")
	public List<Gestionnaire> findAllGestionnaireWithFormation() {
		return gestionnaireRepository.findAll();
	}
	
	@JsonView(JsonViews.Module.class)
	@GetMapping("/formation/module")
	public List<Gestionnaire> findAllGestionnaireWithFormationAndModule() {
		return gestionnaireRepository.findAll();
	}

	@PostMapping("/formation")
	public ResponseEntity<Void> insertFormation(@RequestBody Formation formation, BindingResult br, UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			formation = formationRepository.save(formation);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/formation/{id}").buildAndExpand(formation.getId()).toUri());
			return new ResponseEntity<>(header, HttpStatus.CREATED);
		}

	}

	@DeleteMapping("formation/{id}")
	public void delete(@PathVariable(name = "id") String id) {
		formationService.deleteById(id);
	}

	@JsonView(JsonViews.Formation.class)
	@PutMapping("/formation")
	public Formation update(@Valid @RequestBody Formation formation, BindingResult br) {
		if (br.hasErrors()) {
			return null;
		} else {
			Optional<Formation> opt = formationRepository.findById(formation.getId());
			if (opt.isPresent()) {
				Formation formationEnBase = opt.get();
				formation.setVersion(formationEnBase.getVersion());
				return formationRepository.save(formation);
			} else {
				return null;
			}

		}
	}


}
