package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.VideoProjecteurRepository;

@Service
public class VideoProjecteurService {
	@Autowired
	private VideoProjecteurRepository videoProjecteurRepository;
	
}
