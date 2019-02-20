package com.example.demo.restController;

import java.util.List;
import java.util.Optional;

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

import com.example.demo.entity.Formation;
import com.example.demo.entity.jsonview.JsonViews;
import com.example.demo.repository.FormationRepository;
import com.example.demo.service.FormationService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/rest/formation")
public class FormationRestController {

	@Autowired
	private FormationRepository formationRepository;
	
	@Autowired
	private FormationService formationService;

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
	
	@PostMapping(value = { "", "/" })
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

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name = "id") String id) {
		formationService.deleteById(id);
	}
	

}
