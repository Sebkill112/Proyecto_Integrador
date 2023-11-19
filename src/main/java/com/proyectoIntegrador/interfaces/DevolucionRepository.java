package com.proyectoIntegrador.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.proyectoIntegrador.entity.Devolucion;

public interface DevolucionRepository extends JpaRepository<Devolucion, Integer>{
	
	@Query(value = "{call sp_generar_numeroDev()}" ,nativeQuery = true)
	public String generarNumeroDevolucion();
	
	@Modifying
	@Query(value = "{call DevolucionActualizarEstadoYStock(?1,?2,?3,?4)}" ,nativeQuery = true)
	public void devolucionActualizarEstadoYStock(int codPres, int codEjem,int codLibro,int codSede);

}
