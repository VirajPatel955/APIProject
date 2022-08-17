package com.qa.PokeDexAPI.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;

@Entity
@Table (name = "pokemon")
public class Pokemon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pokemon_id;
	
	@NotNull
	@Column (length = 15)
	private String pokemon_name;
	
	@NotNull
	@Column (length = 15)
	private String first_type;
	
	@NotNull
	@Column (length = 15)
	private String second_type;
	
    public Pokemon() {
		 
	 }
	
	public Pokemon(String pokemon_name, String first_type, String second_type) {
		this.pokemon_name = pokemon_name;
		this.first_type = first_type;
		this.second_type = second_type;
	}

	public Pokemon(Long pokemon_id, String pokemon_name, String first_type, String second_type) {
		this.pokemon_id = pokemon_id;
		this.pokemon_name = pokemon_name;
		this.first_type = first_type;
		this.second_type = second_type;
	}

	public Long getPokemon_id() {
		return pokemon_id;
	}

	public void setPokemon_id(Long pokemon_id) {
		this.pokemon_id = pokemon_id;
	}

	public String getPokemon_name() {
		return pokemon_name;
	}

	public void setPokemon_name(String pokemon_name) {
		this.pokemon_name = pokemon_name;
	}

	public String getFirst_type() {
		return first_type;
	}

	public void setFirst_type(String first_type) {
		this.first_type = first_type;
	}

	public String getSecond_type() {
		return second_type;
	}

	public void setSecond_type(String second_type) {
		this.second_type = second_type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(first_type, pokemon_name, second_type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return Objects.equals(first_type, other.first_type) && Objects.equals(pokemon_name, other.pokemon_name)
				&& Objects.equals(second_type, other.second_type);
	}

	@Override
	public String toString() {
		return "Pokemon [pokemon_id=" + pokemon_id + ", pokemon_name=" + pokemon_name + ", first_type=" + first_type
				+ ", second_type=" + second_type + "]";
	}
	
	
	
	
	
	
	
	
}
