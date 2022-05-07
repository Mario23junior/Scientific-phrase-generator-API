package com.api.project.phraseGenerator.repository;

import java.util.List;

import com.api.project.phraseGenerator.model.Phrases;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhraseRepository extends JpaRepository<Phrases, Long> {
    
	
	@Query(nativeQuery=true, value="SELECT * FROM Phrases ORDER BY RANDOM () LIMIT 1;")
 	List<Phrases> findAllValueData();
	
}
