package com.api.project.phraseGenerator.controller;

import java.util.List;

import com.api.project.phraseGenerator.model.Phrases;
import com.api.project.phraseGenerator.service.phraseService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project/rand")
public class PhraseController {
   
	private phraseService service;
	
	public PhraseController(phraseService service) {
		this.service = service;
 	}
	
	@GetMapping
	public List<Phrases> findDataAll() {
		List<Phrases> data = service.randonPhrase();
		return data;
	}
}
