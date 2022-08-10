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
@Table(name = "pokedex")
public class PokeDex {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long dex_id;
	
	@NotNull
	@Column (length = 15)
	private String pokemon;
	
	@NotNull
	@Column (length = 40)
	private String description;
	
	@Column
	private boolean caught;
	
	 public PokeDex() {
		 
	 }
    
    public PokeDex(String pokemon, String description, boolean caught) {
    	this.pokemon = pokemon;
    	this.description = description;
    	this.caught = caught;
    }
    
    
    public PokeDex(Long dex_id, String pokemon, String description, boolean caught) {
    	this.dex_id = dex_id;
    	this.pokemon = pokemon;
    	this.description =description;
    	this.caught = caught;
    }
    
    public Long getDex_id() {
		return dex_id;
	}


	public void setDex_id(Long dex_id) {
		this.dex_id = dex_id;
	}


	public String getPokemon() {
		return pokemon;
	}

	public void setPokemon(String pokemon) {
		this.pokemon = pokemon;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCaught() {
		return caught;
	}

	public void setCaught(boolean caught) {
		this.caught = caught;
	}

	@Override
	public int hashCode() {
		return Objects.hash(caught, description, pokemon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PokeDex other = (PokeDex) obj;
		return caught == other.caught && Objects.equals(description, other.description)
				&& Objects.equals(pokemon, other.pokemon);
	}

	@Override
	public String toString() {
		return "PokeDex [dex_id=" + dex_id + ", pokemon=" + pokemon + ", description=" + description + ", caught="
				+ caught + "]";
	}



	
    
}

