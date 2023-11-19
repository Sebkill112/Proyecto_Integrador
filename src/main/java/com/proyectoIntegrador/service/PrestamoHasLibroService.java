package com.proyectoIntegrador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoIntegrador.entity.PrestamoHasLibro;
import com.proyectoIntegrador.interfaces.PrestamoHasLibroRepository;

@Service
public class PrestamoHasLibroService {

	@Autowired
	private PrestamoHasLibroRepository repo;
	
	public PrestamoHasLibro grabar(PrestamoHasLibro phl) {
		
		return repo.save(phl);
	}
	
}
