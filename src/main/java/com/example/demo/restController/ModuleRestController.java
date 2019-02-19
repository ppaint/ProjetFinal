package com.example.demo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Module;
import com.example.demo.entity.jsonview.JsonViews;
import com.example.demo.repository.ModuleRepository;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins="*") // = localhost:4200
@RestController
@RequestMapping("/rest/module")
public class ModuleRestController {

	@Autowired
	private ModuleRepository moduleRepository;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(value= {"", "/"}) // donc /rest/module + ça
	public ResponseEntity<List<Module>> findAllModule() {
		return new ResponseEntity<List<Module>>(moduleRepository.findAll(), HttpStatus.OK);
	}
	
}
