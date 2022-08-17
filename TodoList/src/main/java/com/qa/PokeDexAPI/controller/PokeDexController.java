package com.qa.PokeDexAPI.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.PokeDexAPI.model.PokeDex;
import com.qa.PokeDexAPI.repo.PokeDexRepo;
import com.qa.PokeDexAPI.service.PokeDexService;

@RestController
@RequestMapping ("/pokedex")
public class PokeDexController {
	 

	@Autowired
	PokeDexService service;
	
	@Autowired 
	public PokeDexController(PokeDexService pokedexService) {
		this.service = pokedexService;
	}
	
    @Autowired
	private PokeDexRepo pokedexrepo;
	
	@GetMapping("/GetPokemon")
	public ResponseEntity<List<PokeDex>> getPokeDex(){
		List<PokeDex> pokemonData = this.service.readAllPokemon();
		return new ResponseEntity<List<PokeDex>>(pokemonData, HttpStatus.OK);
	}
	@GetMapping("/GetPokemon/{dex_id}")
		public ResponseEntity<PokeDex> ReadPokeDex(@PathVariable Long dex_id){
			return ResponseEntity.ok(this.service.ReadPokeDex(dex_id));
	}
	public List<PokeDex> findAll(){
		return pokedexrepo.findAll();
	}
	
	@PostMapping("/createPokemon")
	public PokeDex save(@Valid @NotNull @RequestBody PokeDex pokedex) {
		return pokedexrepo.save(pokedex);
	}
	
	@PutMapping("/updatePokeDex/{dex_id}")
//	public ResponseEntity<PokeDex>updatePokeDex(@PathVariable("dex_id") long dex_id, @RequestBody PokeDex pokedex){
//		return new ResponseEntity<>(this.service.updatePokeDex(pokedex, dex_id),HttpStatus.ACCEPTED);

	
	public ResponseEntity<PokeDex>updatePokeDex(@RequestBody PokeDex pokedex, @PathVariable Long dex_id){
		PokeDex updatePokeDex = service.updatePokeDex(pokedex, dex_id);
		return new ResponseEntity<PokeDex>(updatePokeDex, HttpStatus.ACCEPTED);
		}
	
//	public PokeDex updatePokeDex(@PathVariable("dex_id") long dex_id, @RequestBody PokeDex pokedex) {
//		return service.updatePokeDex(pokedex, dex_id);
//	}
	
	@DeleteMapping(value = "/deletePokemon/{dex_id}")
	public ResponseEntity<Boolean>deletePokemon(@PathVariable Long dex_id) {
		Boolean deletedPokemon = service.deletebyPokeDexID(dex_id);
		return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
//				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);		
	}
	
	
}
