package com.example.demo.restController;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.entity.Module;
import com.example.demo.entity.jsonview.JsonViews;
import com.example.demo.repository.ModuleRepository;
import com.example.demo.service.ModuleService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins="*") // = localhost:4200
@RestController
@RequestMapping("/rest/module")
public class ModuleRestController {

	@Autowired
	private ModuleRepository moduleRepository;
	
	@Autowired
	private ModuleService moduleService;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(value= {"", "/"}) 
	public ResponseEntity<List<Module>> findAllModule() {
		return new ResponseEntity<List<Module>>(moduleRepository.findAll(), HttpStatus.OK);
	}
	
	@JsonView(JsonViews.Formateur.class)
	@GetMapping("/formateur") 
	public ResponseEntity<List<Module>> findAllModuleWithFormateur() {
		return new ResponseEntity<List<Module>>(moduleRepository.findAll(), HttpStatus.OK);
	}
	
	@JsonView(JsonViews.Matiere.class)
	@GetMapping("/formateur/matiere") 
	public ResponseEntity<List<Module>> findAllModuleWithFormateurAndMatiere() {
		return new ResponseEntity<List<Module>>(moduleRepository.findAll(), HttpStatus.OK);
	}
	
	
	@PostMapping(value= {"", "/"})
	public ResponseEntity<Void> insertFormation(@RequestBody Module module, BindingResult br, UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			module = moduleRepository.save(module);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/module/{titre}").buildAndExpand(module.getTitre()).toUri());
			return new ResponseEntity<>(header, HttpStatus.CREATED);
		}

	}

	@DeleteMapping("/{titre}")
	public void delete(@PathVariable(name = "titre") String titre) {
		moduleService.deleteById(titre);
	}
//
//	@JsonView(JsonViews.Formation.class)
//	@PutMapping("/formation")
//	public Formation update(@Valid @RequestBody Formation formation, BindingResult br) {
//		if (br.hasErrors()) {
//			return null;
//		} else {
//			Optional<Formation> opt = formationRepository.findById(formation.getId());
//			if (opt.isPresent()) {
//				Formation formationEnBase = opt.get();
//				formation.setVersion(formationEnBase.getVersion());
//				return formationRepository.save(formation);
//			} else {
//				return null;
//			}
//
//		}
//	}

}
