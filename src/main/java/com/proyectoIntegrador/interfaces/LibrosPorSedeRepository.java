package com.proyectoIntegrador.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.proyectoIntegrador.entity.LibrosPorSede;

public interface LibrosPorSedeRepository extends JpaRepository<LibrosPorSede, Integer>{
	
	@Query("select e, stock from LibrosPorSede lhs join lhs.libroSede e where lhs.sedeLibro.codigo=?1")
	public List<Object> listaLibrosPorSede (int codigo);
	
	@Modifying
	@Query(value ="update libroshassede set stock = stock - 1 where codigo_libro = ?1 and codigo_sede = ?2",nativeQuery = true)
	public void restarStock(int codLibro, int codSede);
	
	@Modifying
	@Query(value ="update libroshassede set stock = stock + 1 where codigo_libro = ?1 and codigo_sede = ?2",nativeQuery = true)
	public void aumentarStock(int codLibro, int codSede);

}
