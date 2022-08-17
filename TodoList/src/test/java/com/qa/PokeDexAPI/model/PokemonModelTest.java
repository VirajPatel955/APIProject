package com.qa.PokeDexAPI.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import nl.jqno.equalsverifier.EqualsVerifier;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
public class PokemonModelTest {
	
	static Pokemon testPokemon;
	
	@BeforeAll
	public static void buildPokemon() {
	System.out.println("Building Pokemon");
	testPokemon = new Pokemon(1L, "Bulbasaur", "Grass", "Poison");
    }

   @Test
   public void testEquals() {
	   EqualsVerifier.simple().forClass(Pokemon.class).verify();
	   
	   }

   @Test
   public void constructors_Pokemon_Pokemon() {
	   Pokemon pokemonOne = new Pokemon();
	   
	   assertTrue(pokemonOne instanceof Pokemon == true);
	   
	   Pokemon pokemonTwo = new Pokemon(2L ,"Ivysaur", "Grass", "Poison") ;
	   assertTrue(pokemonTwo instanceof Pokemon == true);
	   assertEquals(2, pokemonTwo.getPokemon_id());
		assertEquals("Ivysaur", pokemonTwo.getPokemon_name());
		assertEquals("Grass", pokemonTwo.getFirst_type());
		assertEquals("Poison", pokemonTwo.getSecond_type());
   }
   
   @Test
   public void toString_String_PokemonInstance() {
	   String expecting ="Pokemon [pokemon_id=" + testPokemon.getPokemon_id() + ", pokemon_name"
				+ testPokemon.getPokemon_name() + ", first_type=" + testPokemon.getFirst_type() 
				+ ", second_type=" + testPokemon.getSecond_type()
				+ "]";
   }
		


}
