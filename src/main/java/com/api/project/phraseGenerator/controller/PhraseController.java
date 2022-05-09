package com.api.project.phraseGenerator.controller;

import com.api.project.phraseGenerator.dto.PhrasesDTO;
import com.api.project.phraseGenerator.service.phraseService;

import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<PhrasesDTO> findDataAll() {
		ResponseEntity<PhrasesDTO> data = service.randonPhrase();
		return data;
	}
}
