package com.qa.PokeDexAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.PokeDexAPI.model.PokeDex;
import com.qa.PokeDexAPI.repo.PokeDexRepo;

@Service
public class PokeDexService {
	
	@Autowired
	
	private PokeDexRepo repo;
	
	@Autowired
	public PokeDexService(PokeDexRepo repo) {
		this.repo = repo;
	}
	
	//Create
	public PokeDex addPokemon(PokeDex pokemon) {
		return repo.save(pokemon);
	}

	//Read
	public PokeDex ReadPokeDex(Long dex_id) {
		return repo.findById(dex_id).get();
		
		}
    public List<PokeDex> readAllPokemon() {
		return this.repo.findAll();
	}
	
	//Update
	public PokeDex updatePokeDex(PokeDex updatePokeDex, Long dex_id ) {
		Optional<PokeDex> currentPokemon = this.repo.findById(dex_id);
		
		if(currentPokemon.get() instanceof PokeDex) {
			PokeDex oldPokemon = currentPokemon.get();
			
			oldPokemon.setPokemon(updatePokeDex.getPokemon());
			oldPokemon.setDescription(updatePokeDex.getDescription());
			oldPokemon.setCaught(false);
			return repo.save(oldPokemon);
		}
		
		return null;
	}
	
	//Delete
	
	public boolean deletebyPokeDexID(Long dex_id) {
		Optional<PokeDex> currentPokemon = this.repo.findById(dex_id);
		
		boolean isPresent = (currentPokemon.isPresent()) ? true : false;
		
		if (isPresent ) {
			this.repo.deleteById(dex_id);
		return true;
		} else {
			return false;
			
		}
		
		
	}
}


