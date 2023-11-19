package com.proyectoIntegrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoIntegrador.entity.Libro;
import com.proyectoIntegrador.interfaces.LibroRespository;

@Service
public class LibroService {

	
	@Autowired
	private LibroRespository repo;
	
	public List<Libro> listadoLibros () {
		
		return repo.findAll();
	}
	
	
public List<Libro> listadoLibrosPorGenero (int cod) {
		
		return repo.buscarPorGenero(cod);
	}
	
	public Libro grabarActualizaLibro(Libro libro) {
		return repo.save(libro);
	}
	
	public void eliminaLibro(int id) {
		repo.deleteById(id);
	}
}
