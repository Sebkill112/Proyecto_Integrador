package com.proyectoIntegrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoIntegrador.entity.Ejemplar;
import com.proyectoIntegrador.service.EjemplarService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/ejemplar")
@RequiredArgsConstructor
public class EjemplarController {
	
	@Autowired
	private EjemplarService servicio;
	
	@GetMapping(value = "listado")
	@ResponseBody
	public ResponseEntity<List<Ejemplar>> listar(@RequestParam int libro, @RequestParam int sede){
		List<Ejemplar> lista = servicio.listarEjemplares(libro,sede);
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping(value = "estado")
	@ResponseBody
	public ResponseEntity<List<Ejemplar>> listarPorEstados(@RequestParam int libro, @RequestParam int sede){
		List<Ejemplar> lista = servicio.listarEjemplaresPorEstado(libro,sede);
		return ResponseEntity.ok(lista);
	}
}
