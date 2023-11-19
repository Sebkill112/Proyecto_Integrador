package com.proyectoIntegrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoIntegrador.service.LibrosPorSedeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/libroSede")
@RequiredArgsConstructor
public class LibrosPorSedeController {
	
	@Autowired
	private LibrosPorSedeService servicio;
	
	@GetMapping(value = "listado")
	@ResponseBody
	public ResponseEntity<List<Object>> listar(@RequestParam int cod){
		List<Object> lista = servicio.listadoPorSede(cod);
		return ResponseEntity.ok(lista);
	}

}
