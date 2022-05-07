package com.api.project.phraseGenerator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Phrases {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String phrases;
	private String author;
	
	public Phrases() {
		//TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhrases() {
		return phrases;
	}

	public void setPhrases(String phrases) {
		this.phrases = phrases;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
