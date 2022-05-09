package com.api.project.phraseGenerator.service;

import java.util.Optional;

import com.api.project.phraseGenerator.dto.PhrasesDTO;
import com.api.project.phraseGenerator.model.Phrases;
import com.api.project.phraseGenerator.repository.PhraseRepository;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class phraseService {

 	private PhraseRepository phraseRepository;
 	private ModelMapper mapper;

	public phraseService(PhraseRepository phraseRepository,ModelMapper mapper) {
		this.phraseRepository = phraseRepository;
		this.mapper = mapper;
 	}

	public ResponseEntity<PhrasesDTO> randonPhrase() {
		Optional<Phrases> list = phraseRepository.findAllValueData();
		if(list.isPresent()) {
			return ResponseEntity.ok(mapper.map(list.get(), PhrasesDTO.class));
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	
	}

}
