package com.proyectoIntegrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoIntegrador.entity.Sede;
import com.proyectoIntegrador.interfaces.SedeRepository;

@Service
public class SedeService {

	@Autowired
	private SedeRepository repo;
	
	public List<Sede> listadoSede() {
		
		return repo.findAll();
		
	}
	
	public Sede registrar(Sede sede) {
		return repo.save(sede);
	}
	
	public void eliminaSede(int id) {
		repo.deleteById(id);
	}
	
}
