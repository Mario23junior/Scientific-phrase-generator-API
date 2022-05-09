package com.api.project.phraseGenerator.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigmodelMapper {

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
}
