package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.GestionnaireRepository;

@Service
public class GestionnaireService {
	
	@Autowired
	private GestionnaireRepository gestionnaireRepository;

}
