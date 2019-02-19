package com.example.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Adresse;
import com.example.demo.entity.Coordonnees;
import com.example.demo.entity.Formateur;
import com.example.demo.entity.Formation;
import com.example.demo.entity.Gestionnaire;
import com.example.demo.entity.Ordinateur;
import com.example.demo.entity.Salle;
import com.example.demo.entity.Stagiaire;
import com.example.demo.entity.Technicien;
import com.example.demo.entity.VideoProjecteur;
import com.example.demo.repository.FormateurRepository;
import com.example.demo.repository.FormationRepository;
import com.example.demo.repository.GestionnaireRepository;
import com.example.demo.repository.OrdinateurRepository;
import com.example.demo.repository.SalleRepository;
import com.example.demo.repository.StagiaireRepository;
import com.example.demo.repository.TechnicienRepository;
import com.example.demo.repository.VideoProjecteurRepository;
import com.example.demo.service.FormationService;

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
	@Autowired
	private SalleRepository salleRepository;
	@Autowired
	private OrdinateurRepository ordinateurRepository;
	@Autowired
	private VideoProjecteurRepository videoProjecteurRepository;
	@Autowired
	private FormationRepository formationRepository;
	@Autowired
	private FormationService formationService;

	
	
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
	
	@Test
	public void listOrdinateur() {
		Ordinateur f = new Ordinateur();
		f.setCout((long)28.5);
		f.setAnnee(2005);
		f.setRam(32);
		f.setCode("Azdaz85sfea6");
		ordinateurRepository.save(f);
		assertNotNull(ordinateurRepository.findAll());
		ordinateurRepository.delete(f);
	}
	
	@Test
	public void listSalle() {
		Salle f = new Salle();
		f.setCout((long)28.5);
		f.setCode("Azdaz85sfea6");
		salleRepository.save(f);
		assertNotNull(salleRepository.findAll());
		salleRepository.delete(f);
	}
	
	@Test
	public void listVideoProjecteur() {
		VideoProjecteur f = new VideoProjecteur();
		f.setCout((long)28.5);
		f.setCode("Azdaz85sfea6");
		videoProjecteurRepository.save(f);
		assertNotNull(videoProjecteurRepository.findAll());
		videoProjecteurRepository.delete(f);
	}
	
	@Test
	public void listFormation() {
		Formation f = new Formation();
		f.setId("sopra");
		formationRepository.save(f);
		assertNotNull(formationRepository.findAll());
		formationRepository.delete(f);
	}
	
	@Test
	public void deleteFormation() {
		Optional<Formation> opt = formationRepository.findByIdWithStagiaire("Emeraude");
		if(opt.get()!= null) {
			formationService.delete(opt.get());
		}
		assertNull(formationRepository.findById("Emeraude").get());
	}
}
