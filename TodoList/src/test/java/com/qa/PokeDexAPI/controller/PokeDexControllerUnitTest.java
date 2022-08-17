package com.qa.PokeDexAPI.controller;

import static org.assertj.core.api.Assertions.offset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.qa.PokeDexAPI.model.PokeDex;
import com.qa.PokeDexAPI.service.PokeDexService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
public class PokeDexControllerUnitTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private PokeDexService service;
	
	@Autowired
	private PokeDexController controller;
	
	@Test 
	public void createPokemonTest() throws Exception{
		PokeDex testEntry = new PokeDex("Ivysaur", "Seed Pokemon", false );
		String testPokeDexAsJSON = this.mapper.writeValueAsString(testEntry);
		
		Mockito.when(this.service.addPokemon(testEntry)).thenReturn(testEntry);
		
		mvc.perform(post("pokedex/createPokemon")
				.content(testPokeDexAsJSON)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated())
		.andExpect(content().json(testPokeDexAsJSON));
		
		Mockito.verify(this.service, Mockito.times(1)).addPokemon(testEntry);
	}
	
 
	
	

}
