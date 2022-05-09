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
	
	public ResponseEntity<PhrasesDTO> savePhrase(PhrasesDTO phrasesDto) {
		ValidDataDuplicate(phrasesDto);
		Phrases body = bodySaveBase(mapper.map(phrasesDto, Phrases.class));
		 return ResponseEntity
				         .status(HttpStatus.OK)
				         .body(mapper.map(body, PhrasesDTO.class));
		 
	}

	public Phrases bodySaveBase(Phrases phrases) {
		return phraseRepository.save(phrases);
	}
	
	public void ValidDataDuplicate(PhrasesDTO phrasesDto) {
		Phrases dtoList = mapper.map(phrasesDto, Phrases.class);
		Phrases findData = phraseRepository.findByPhrases(phrasesDto.getPhrases());
		if(findData != null && findData.getId() != dtoList.getId()) {
			ResponseEntity.noContent();
		}
	}
	
	public ResponseEntity<PhrasesDTO> update(Long id, PhrasesDTO phrasesDto){
		Optional<Phrases> findDataAll = phraseRepository.findById(id);
		if(findDataAll.isPresent()) {
			Phrases data = findDataAll.get();
			data.setPhrases(phrasesDto.getPhrases());
			data.setAuthor(phrasesDto.getAuthor());
			phraseRepository.save(data);
			return ResponseEntity.ok(mapper.map(data, PhrasesDTO.class));	
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	public ResponseEntity<PhrasesDTO> delete(Long id) {
		Optional<Phrases> findId = phraseRepository.findById(id);
		if(findId.isPresent()) {
			phraseRepository.delete(findId.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
 	}
	
	
}
