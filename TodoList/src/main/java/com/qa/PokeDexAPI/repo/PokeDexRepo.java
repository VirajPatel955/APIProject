package com.qa.PokeDexAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.PokeDexAPI.model.PokeDex;

public interface PokeDexRepo extends JpaRepository<PokeDex, Long>  {

}
