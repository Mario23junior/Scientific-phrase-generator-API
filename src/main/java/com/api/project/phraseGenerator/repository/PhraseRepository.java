package com.api.project.phraseGenerator.repository;

import com.api.project.phraseGeneratormodel.Phrases;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhraseRepository extends JpaRepository<Phrases, Long> {

}
