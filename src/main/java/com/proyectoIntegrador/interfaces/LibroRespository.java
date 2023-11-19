package com.proyectoIntegrador.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectoIntegrador.entity.Libro;

public interface LibroRespository extends JpaRepository<Libro, Integer>{
	
	@Query(value = "select * from libros where cod_genero = ?1", nativeQuery = true)
	public List<Libro> buscarPorGenero(int cod);

}
