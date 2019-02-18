package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.SalleRepository;

@Service
public class SalleService {

	@Autowired
	private SalleRepository salleRepository;
	
}
