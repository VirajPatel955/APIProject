package com.qa.PokeDexAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
//@ComponentScan("com.qa")
public class PokedexApplication{ //implements CommandLineRunner 
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(PokedexApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		String  sql = "INSERT INTO pokedex (pokemon, desciption, caught) VALUES (?, ? ?)";
//		
//		int result = jdbcTemplate.update(sql, "Bulbasaur", "Seed Pokemon", false);
//		
//		if (result > 0) { 
//			System.out.println("New Pokemon is added!");
//		}
//	}

}
