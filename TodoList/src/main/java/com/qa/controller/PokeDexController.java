package com.qa.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.model.PokeDex;
import com.qa.repo.PokeDexRepo;

@RestController
@RequestMapping (value = "/home")
public class PokeDexController {

	
	@Autowired
	private PokeDexRepo pokedexrepo;
	
	@GetMapping("/GetPokemon")
	public List<PokeDex> findAll(){
		return pokedexrepo.findAll();
	}
	
	@PostMapping("/createPokemon")
	public PokeDex save(@Valid @NotNull @RequestBody PokeDex pokedex) {
		return pokedexrepo.save(pokedex);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long dex_id) {
		pokedexrepo.deleteById(dex_id);
	}
	
}
