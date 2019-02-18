package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.FormationRepository;

@Service
public class FormationService {
@Autowired
private FormationRepository formationRepository;

}
