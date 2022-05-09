package com.api.project.phraseGenerator.repository;

import java.util.Optional;

import com.api.project.phraseGenerator.model.Phrases;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhraseRepository extends JpaRepository<Phrases, Long> {
    
	
	@Query(nativeQuery=true, value="SELECT * FROM Phrases ORDER BY RANDOM () LIMIT 1;")
 	Optional<Phrases> findAllValueData();

	Phrases findByPhrases(String phrases);
	
}
