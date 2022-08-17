package com.qa.PokeDexAPI.controller;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import com.qa.PokeDexAPI.service.PokeDexService;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:pokdexdb-schema.sql","classpath:data.sql"})

@ActiveProfiles("test")
public class PokeDexControllerIntergrationTest {
	
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired 
	private Mapper mapper;
	
	@Autowired
	private PokeDexService service;
	

}
