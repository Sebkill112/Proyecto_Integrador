package com.proyectoIntegrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoIntegrador.entity.Genero;
import com.proyectoIntegrador.interfaces.GeneroRepository;

@Service
public class GeneroService {

	@Autowired
	private GeneroRepository repo;
	
	
	public List<Genero> listarTodo(){
		return repo.findAll();
	}
	
}
