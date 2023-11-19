package com.proyectoIntegrador.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectoIntegrador.entity.Ejemplar;

public interface EjemplarRepository extends JpaRepository<Ejemplar, Integer>{

	
	@Query("select e from Ejemplar e where e.libroEjemplar.codigo = ?1 and e.sedeEjemplar.codigo = ?2")
	public List<Ejemplar> listarEjemplaresSedeLibro(int lib, int sed);
	
	@Query("select e from Ejemplar e where e.libroEjemplar.codigo = ?1 and e.sedeEjemplar.codigo = ?2 and e.estado = 1")
	public List<Ejemplar> listarEjemplaresSedeLibroEstado(int lib, int sed);
	
}
