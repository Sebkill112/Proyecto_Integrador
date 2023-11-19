package com.proyectoIntegrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoIntegrador.entity.Devolucion;
import com.proyectoIntegrador.interfaces.DevolucionRepository;

@Service
public class DevolucionService {

	@Autowired
	private DevolucionRepository repo;
	
	public List<Devolucion> listarDevolucion () {
		return repo.findAll();
	}
	
	public Devolucion registrar(Devolucion bean) {
		return repo.save(bean);
	}
	
	public String GenerarCodigo() {
		return repo.generarNumeroDevolucion();
	}
	
	public void DevolucionActualizarEstadoYStock(int codPres, int codEjem,int codLibro,int codSede) {
		repo.devolucionActualizarEstadoYStock(codPres, codEjem, codLibro, codSede);
	}
	
}
