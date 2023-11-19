package com.proyectoIntegrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoIntegrador.entity.Ejemplar;
import com.proyectoIntegrador.entity.Libro;
import com.proyectoIntegrador.entity.LibrosPorSede;
import com.proyectoIntegrador.entity.Sede;
import com.proyectoIntegrador.interfaces.EjemplarRepository;
import com.proyectoIntegrador.interfaces.LibrosPorSedeRepository;

import jakarta.transaction.Transactional;

@Service
public class LibrosPorSedeService {

	@Autowired 
	private LibrosPorSedeRepository repo;
	
	@Autowired 
	private EjemplarRepository repoEjemplar;
	
	public List<Object> listadoPorSede(int cod){
		return repo.listaLibrosPorSede(cod);
	}
	
	public void RestarStockLibro(int codLibro, int codSede) {
		repo.restarStock(codLibro, codSede);
		
	}
	
	public void AumentarStockLibro(int codLibro, int codSede) {
		repo.aumentarStock(codLibro, codSede);
		
	}
	
	@Transactional
    public void actualizarStockYEstado(int idLibro, int idSede, int nuevoStock) {
        // Buscar o crear LibrosPorSede
        LibrosPorSede librosPorSede = repo.findBySedeLibroCodigoAndLibroSedeCodigo(idSede, idLibro);

        if (librosPorSede != null) {
        	 int stockExistente = librosPorSede.getStock();
             librosPorSede.setStock(stockExistente + nuevoStock);
        } else {
            librosPorSede = new LibrosPorSede();
            Libro l = new Libro();
            l.setCodigo(idLibro);
            Sede s = new Sede();
            s.setCodigo(idSede);
            librosPorSede.setSedeLibro(s);
            librosPorSede.setLibroSede(l);
            librosPorSede.setStock(nuevoStock);
        }

        repo.save(librosPorSede);

        // Insertar cantidad de stock en bucle sin buscar
        for (int i = 0; i < nuevoStock; i++) {
        	Libro l = new Libro();
            l.setCodigo(idLibro);
            Sede s = new Sede();
            s.setCodigo(idSede);
            // Crea un nuevo Ejemplar para cada unidad de stock
            Ejemplar nuevoEjemplar = new Ejemplar();
            nuevoEjemplar.setLibroEjemplar(l);
            nuevoEjemplar.setSedeEjemplar(s);
            nuevoEjemplar.setEstado(1);

            repoEjemplar.save(nuevoEjemplar);
        }
    }
}
