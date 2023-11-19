package com.proyectoIntegrador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoIntegrador.entity.DevolucionHasLibro;
import com.proyectoIntegrador.interfaces.DevolucionHasLibroRepository;

@Service
public class DevolucionHasLibroService {
	
	@Autowired
	private DevolucionHasLibroRepository repo;
	
	public DevolucionHasLibro grabar(DevolucionHasLibro dhl) {
		
		return repo.save(dhl);
	}

}
