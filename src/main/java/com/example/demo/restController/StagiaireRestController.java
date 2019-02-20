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

import com.example.demo.entity.Stagiaire;
import com.example.demo.entity.jsonview.JsonViews;
import com.example.demo.repository.StagiaireRepository;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/rest/stagiaire")
public class StagiaireRestController {

	@Autowired
	private StagiaireRepository stagiaireRepository;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<Stagiaire>> findAllGestionnaire() {
		return new ResponseEntity<List<Stagiaire>>(stagiaireRepository.findAll(), HttpStatus.OK);
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public ResponseEntity<Stagiaire> findById(@PathVariable(name = "id") Integer id) {
		Optional<Stagiaire> opt = stagiaireRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Stagiaire>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	
	@PostMapping(value = { "", "/" })
	public ResponseEntity<Void> insertStagiaire(@RequestBody Stagiaire stagiaire, BindingResult br, UriComponentsBuilder uCB) {
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			stagiaire = stagiaireRepository.save(stagiaire);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/stagiaire/{id}").buildAndExpand(stagiaire.getId()).toUri());
			return new ResponseEntity<>(header, HttpStatus.CREATED);
		}

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name = "id") Integer id) {
		stagiaireRepository.deleteById(id);
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping(value = { "", "/" })
	public Stagiaire update(@Valid @RequestBody Stagiaire stagiaire, BindingResult br) {
		if (br.hasErrors()) {
			return null;
		} else {
			Optional<Stagiaire> opt = stagiaireRepository.findById(stagiaire.getId());
			if (opt.isPresent()) {
				Stagiaire stagiaireEnBase = opt.get();
				stagiaire.setVersion(stagiaireEnBase.getVersion());
				return stagiaireRepository.save(stagiaire);
			} else {
				return null;
			}

		}
	}

}
