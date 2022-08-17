package com.qa.PokeDexAPI.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.PokeDexAPI.model.PokeDex;

@Repository
public interface PokeDexRepo extends JpaRepository<PokeDex, Long>  {

	@Query(value ="SELECT * pokedexdb", nativeQuery = true)
	public List<PokeDex> allFromPokeDex();
	
	@Query(value ="SELECT * FROM pokedexdb where pokemon = ?", nativeQuery = true)
	public List<PokeDex> samePokemonSelect(String pokemon);
	
}
