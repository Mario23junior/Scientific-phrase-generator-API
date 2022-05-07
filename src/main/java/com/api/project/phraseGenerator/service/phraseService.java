package com.api.project.phraseGenerator.service;

import java.util.List;

import com.api.project.phraseGenerator.model.Phrases;
import com.api.project.phraseGenerator.repository.PhraseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class phraseService {

	@Autowired
	private PhraseRepository phraseRepository;

	public List<Phrases> randonPhrase() {
		List<Phrases> list = phraseRepository.findAllValueData();
		return list;
	}

}
