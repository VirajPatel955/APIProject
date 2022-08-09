package com.qa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.model.PokeDex;

public interface PokeDexRepo extends JpaRepository<PokeDex, Long>  {

}
