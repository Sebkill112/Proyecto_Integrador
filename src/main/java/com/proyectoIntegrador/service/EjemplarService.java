package com.proyectoIntegrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoIntegrador.entity.Ejemplar;
import com.proyectoIntegrador.interfaces.EjemplarRepository;

@Service
public class EjemplarService {
	
	@Autowired
	private EjemplarRepository repo;
	
	public List<Ejemplar> listarEjemplares (int lib , int est) {
		return repo.listarEjemplaresSedeLibro(lib, est);
	}
	
	public List<Ejemplar> listarEjemplaresPorEstado (int lib , int est ) {
		return repo.listarEjemplaresSedeLibroEstado(lib, est);
	}
	

}
