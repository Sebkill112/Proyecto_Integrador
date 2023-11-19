package com.proyectoIntegrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoIntegrador.interfaces.LibrosPorSedeRepository;

@Service
public class LibrosPorSedeService {

	@Autowired 
	private LibrosPorSedeRepository repo;
	
	public List<Object> listadoPorSede(int cod){
		return repo.listaLibrosPorSede(cod);
	}
	
	public void RestarStockLibro(int codLibro, int codSede) {
		repo.restarStock(codLibro, codSede);
		
	}
	
	public void AumentarStockLibro(int codLibro, int codSede) {
		repo.aumentarStock(codLibro, codSede);
		
	}
}
