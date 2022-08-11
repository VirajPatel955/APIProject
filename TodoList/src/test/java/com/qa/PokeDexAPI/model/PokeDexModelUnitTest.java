package com.qa.PokeDexAPI.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import nl.jqno.equalsverifier.EqualsVerifier;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


public class PokeDexModelUnitTest {

	static PokeDex testPokeDex;
	
	@BeforeAll
	public static void buildPokeDexEntry() {
		System.out.println("Building PokeDex");
		testPokeDex = new PokeDex(1L, "Bulbasaur","Seed Pokemon", false);
	}
	
	@Test
	public void constructorWithoutID() {
	//assertNull(testPokeDex.getDex_id());
	assertNotNull(testPokeDex.getPokemon());
	assertNotNull(testPokeDex.getDescription());
	assertNotNull(testPokeDex.isCaught());
	
	}
	
	@Test
	public void TestSetters() {
		
//    	assertNull(testPokeDex.getDex_id());
//	    assertNotNull(testPokeDex.getPokemon());
		assertNotNull(testPokeDex.getDescription());
		assertNotNull(testPokeDex.isCaught());
		
		testPokeDex.setDex_id(null);
		assertNull(testPokeDex.getDex_id());
		testPokeDex.setPokemon(null);
		assertNotNull(testPokeDex.getPokemon());
		testPokeDex.setDescription(null);
		//assertNotNull(testPokeDex.getDescription());
		testPokeDex.setCaught(false);
		//assertNotNull(testPokeDex.isCaught());
	}
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(PokeDex.class).verify();
	}
	
	@Test
	public void constructors_PokeDex_PokeDex() {
		PokeDex entryOne = new PokeDex();
		
		assertTrue(entryOne instanceof PokeDex == true);
		
		PokeDex entryTwo = new PokeDex(2L, "Ivysaur", "Seed Pokemon",false);
		assertTrue(entryTwo instanceof PokeDex == true);
		assertEquals(2, entryTwo.getDex_id());
		assertEquals("Ivysaur", entryTwo.getPokemon());
		assertEquals("Seed Pokemon", entryTwo.getDescription());
		assertEquals(false, entryTwo.isCaught());
		
	}
	
	@Test
	public void toString_String_PokeDexInstance() {
//		String expecting = "PokeDex [dex_id=2, pokemon=Ivysaur, description=SeedPokemon, caught=false]";
		String expecting ="Pokedex [dex_id=" + testPokeDex.getDex_id() + ", pokemon"
				+ testPokeDex.getPokemon() + ", description=" + testPokeDex.getDescription()
				+ "]";
////				+ " , caught=" testPokeDex.isCaught() + "]";
		
		assertEquals(expecting, testPokeDex.toString());	
		
	}
}
