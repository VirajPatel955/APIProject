package com.qa.PokeDexAPI.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.PokeDexAPI.model.PokeDex;
import com.qa.PokeDexAPI.repo.PokeDexRepo;

@SpringBootTest
public class PokeDexServiceUnitTest {
	
	@Autowired
	private PokeDexService service;
	
	@MockBean
	private PokeDexRepo repo;
	
	@Test 
	public void createEntry_ValidEntry_SaveEntry() {
		PokeDex savePokemon = new PokeDex("Bulbasaur", "Seed Pokemon", false);
		PokeDex repoPokemon = new PokeDex(1L, "Bulbasaur", "Seed Pokemon", false);
		
		Mockito.when(this.service.addPokemon(savePokemon)).thenReturn(repoPokemon);
		
		assertEquals(repoPokemon, this.repo.save(savePokemon));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(savePokemon);
		
	}
	
	@Test
	public void updatePokeDex_ValidId_UpdatePokedex() {
		Long testDex_id = 1L;
		
		PokeDex	updatePokeDex = new PokeDex("Ivysaur", "Seed Pokemon", false);
		Optional<PokeDex> mockOutputValid = Optional.ofNullable(new PokeDex(1L,  "Bulbasaur", "Seed Pokemon", false));
		PokeDex expectedOutput = new PokeDex(1L,  "Bulbasaur", "Seed Pokemon", false);
		
		Mockito.when(this.repo.findById(testDex_id)).thenReturn(mockOutputValid);
		Mockito.when(this.repo.save(expectedOutput)).thenReturn(expectedOutput);
		
		assertEquals(expectedOutput, this.service.updatePokeDex(expectedOutput,1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(expectedOutput);
		Mockito.verify(this.repo,Mockito.times(1)).findById(testDex_id);
		
	}
	
	@Test
	public void deletePokeDex_ValidId_deletePokeDex() {
		
	}
	

}
