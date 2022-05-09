package com.api.project.phraseGenerator.controller;

import com.api.project.phraseGenerator.dto.PhrasesDTO;
import com.api.project.phraseGenerator.service.phraseService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping
	public ResponseEntity<PhrasesDTO> saveData(@RequestBody PhrasesDTO phrasDto){
		return service.savePhrase(phrasDto);
	}
	
	@PutMapping
	public ResponseEntity<PhrasesDTO> update(@RequestBody PhrasesDTO phrasDto, @PathVariable Long id){
		return service.update(id, phrasDto);
	}
	
	
	

}
