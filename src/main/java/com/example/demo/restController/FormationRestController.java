package com.example.demo.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Formation;
import com.example.demo.entity.jsonview.JsonViews;
import com.example.demo.repository.FormationRepository;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/rest/formation")
public class FormationRestController {

	@Autowired
	private FormationRepository formationRepository;

	@JsonView(JsonViews.Common.class)
	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<Formation>> findAllFormation() {
		return new ResponseEntity<List<Formation>>(formationRepository.findAll(), HttpStatus.OK);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public ResponseEntity<Formation> findById(@PathVariable(name = "id") String id) {
		Optional<Formation> opt = formationRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Formation>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	
	@JsonView(JsonViews.Module.class)
	@GetMapping("/{id}/module")
	public ResponseEntity<Formation> findByIdWithModule(@PathVariable(name = "id") String id) {
		Optional<Formation> opt = formationRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Formation>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@JsonView(JsonViews.Module.class)
	@GetMapping("/module")
	public ResponseEntity<List<Formation>> findAllFormationWithModule() {
		return new ResponseEntity<List<Formation>>(formationRepository.findAll(), HttpStatus.OK);
	}
	
//	@JsonView(JsonViews.GestionnaireWithFormation.class)
//	@GetMapping("/formation")
//	public List<Gestionnaire> findAllGestionnaireWithFormation() {
//		return gestionnaireRepository.findAll();
//	}

//	private ResponseEntity<Void> insertGestionnaire(Gestionnaire gestionnaire, BindingResult br, UriComponentsBuilder uCB) {
//		if (br.hasErrors()) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		} else {
//			gestionnaireRepository.save(gestionnaire);
//			HttpHeaders header = new HttpHeaders();
//			header.setLocation(uCB.path("/rest/gestionnaire/{id}").buildAndExpand(gestionnaire.getNumero()).toUri());
//			return new ResponseEntity<>(header, HttpStatus.CREATED);
//		}
//
//	}
//
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable(name = "id") Integer id) {
//		gestionnaireRepository.deleteById(id);
//	}
//
//	@JsonView(JsonViews.Common.class)
//	@PutMapping("/eleve")
//	public gestionnaire updateEleve(@Valid @RequestBody Eleve eleve, BindingResult br) {
//		return update(eleve, br);
//	}
//
//	@JsonView(JsonViews.Common.class)
//	@PutMapping("/formateur")
//	public gestionnaire updateFormateur(@Valid @RequestBody Formateur formateur, BindingResult br) {
//		return update(formateur, br);
//	}
//
//	private gestionnaire update(gestionnaire gestionnaire, BindingResult br) {
//		if (br.hasErrors()) {
//			return null;
//		} else {
//			Optional<gestionnaire> opt = gestionnaireRepository.findById(gestionnaire.getNumero());
//			if (opt.isPresent()) {
//				gestionnaire gestionnaireEnBase = opt.get();
//				gestionnaire.setVersion(gestionnaireEnBase.getVersion());
//				return gestionnaireRepository.save(gestionnaire);
//			} else {
//				return null;
//			}
//
//		}
//	}
}
