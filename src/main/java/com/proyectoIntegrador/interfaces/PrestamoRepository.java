package com.proyectoIntegrador.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.proyectoIntegrador.entity.Enlace;
import com.proyectoIntegrador.entity.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
	
	@Modifying
	@Query(value ="update prestamo set estado =:estado WHERE num_prestamo =:num",nativeQuery = true)
	public void actualizaEstado(String estado,String num);
	
	@Query("select p from Prestamo p  where p.estado=?1")
	public List<Prestamo>listarPorEstado(String est);
	
	@Query(value = "select * from prestamo where num_prestamo = ?1", nativeQuery = true)
	public Prestamo buscarPorNumero(String cod);
	
	@Query(value = "select x  from Prestamo x where x.usuario.codigo = ?1")
	public List<Prestamo> buscarPorUsuario(int cod);
	
	@Modifying
	@Query(value ="update prestamo set observacion =?1 WHERE num_prestamo =?2",nativeQuery = true)
	public void actualizarObservacion(String observacion,String num);

	@Query(value = "{call sp_generar_numero()}" ,nativeQuery = true)
	public String generarNumeroPrestamo();
	
	@Modifying
	@Query(value = "{call RetiroActualizarEstadoYStock(?1,?2,?3,?4)}" ,nativeQuery = true)
	public void retiroActulizaEstadoStock(int codPres, int codEjem,int codLibro,int codSede);
	
}
