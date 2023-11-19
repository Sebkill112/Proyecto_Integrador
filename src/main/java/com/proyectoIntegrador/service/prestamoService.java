package com.proyectoIntegrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyectoIntegrador.entity.Libro;
import com.proyectoIntegrador.entity.Prestamo;
import com.proyectoIntegrador.entity.PrestamoHasLibro;
import com.proyectoIntegrador.entity.PrestamoHasLibroPK;
import com.proyectoIntegrador.interfaces.PrestamoHasLibroRepository;
import com.proyectoIntegrador.interfaces.PrestamoRepository;

@Service
public class prestamoService {

	@Autowired
	private PrestamoRepository repo;
	

	

	public Prestamo registrar(Prestamo bean) {
		return repo.save(bean);
	}
	
	public List<Prestamo> listarTodo() {
		return repo.findAll();
	}
	
	public List<Prestamo> listarPorEstado(String estado) {
		return repo.listarPorEstado(estado);
	}
	
	public void ActualizarEstado(String est, String num) {
		repo.actualizaEstado(est, num);
	}
	
	public void ActualizarObservacion(String obs, String num) {
		repo.actualizarObservacion(obs, num);
	}
	
	public Prestamo buscarPorNumero (String cod) {
		return repo.buscarPorNumero(cod);
	}
	
	public void RetiroActulizaEstadoStock(int codPres, int codEjem,int codLibro,int codSede) {
		repo.retiroActulizaEstadoStock(codPres, codEjem, codLibro, codSede);
	}
	
	public String GenerarCodigo() {
		return repo.generarNumeroPrestamo();
	}
	
	public List<Prestamo> buscarPorUsuario(int cod){
		return repo.buscarPorUsuario(cod);
	}
	
	
	
	
}
