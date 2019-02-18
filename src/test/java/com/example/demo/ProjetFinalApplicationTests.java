package com.example.demo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Adresse;
import com.example.demo.entity.Coordonnees;
import com.example.demo.entity.Formateur;
import com.example.demo.entity.Gestionnaire;
import com.example.demo.entity.Stagiaire;
import com.example.demo.entity.Technicien;
import com.example.demo.repository.FormateurRepository;
import com.example.demo.repository.GestionnaireRepository;
import com.example.demo.repository.StagiaireRepository;
import com.example.demo.repository.TechnicienRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjetFinalApplicationTests {
	
	@Autowired
	private FormateurRepository formateurRepository;
	@Autowired
	private StagiaireRepository stagiaireRepository;
	@Autowired
	private GestionnaireRepository gestionnaireRepository;
	@Autowired
	private TechnicienRepository technicienRepository;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void listFormateur() {
		Formateur f = new Formateur("prenom", "nom", new Coordonnees(), new Adresse());
		formateurRepository.save(f);
		assertNotNull(formateurRepository.findAll());
		formateurRepository.delete(f);
	}
	
	@Test
	public void listStagiaire() {
		Stagiaire s = new Stagiaire("prenom", "nom", new Coordonnees(), new Adresse());
		stagiaireRepository.save(s);
		assertNotNull(stagiaireRepository.findAll());
		stagiaireRepository.delete(s);
	}
	
	@Test
	public void listTechnicien() {
		Technicien f = new Technicien("prenom", "nom", new Coordonnees(), new Adresse());
		technicienRepository.save(f);
		assertNotNull(technicienRepository.findAll());
		technicienRepository.delete(f);
	}
	
	@Test
	public void listGestionnaire() {
		Gestionnaire f = new Gestionnaire("prenom", "nom", new Coordonnees(), new Adresse());
		gestionnaireRepository.save(f);
		assertNotNull(gestionnaireRepository.findAll());
		gestionnaireRepository.delete(f);
	}
	
	

}