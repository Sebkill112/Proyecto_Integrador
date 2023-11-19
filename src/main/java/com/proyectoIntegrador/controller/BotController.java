package com.proyectoIntegrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoIntegrador.entity.Libro;
import com.proyectoIntegrador.entity.Prestamo;
import com.proyectoIntegrador.service.LibroService;
import com.proyectoIntegrador.service.prestamoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/bot")
@RequiredArgsConstructor
public class BotController {
	
	
	@Autowired
	private LibroService servicioLibro;
	
	
	@Autowired
	private prestamoService servicioPrestamo;
	
	@GetMapping(value = "generos")
	@ResponseBody
	public ResponseEntity<List<Libro>> listar(@RequestParam int cod){
		List<Libro> lista = servicioLibro.listadoLibrosPorGenero(cod);
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping(value = "prestamo")
	@ResponseBody
	public ResponseEntity<?>  listarPorEstados(@RequestParam String num){
		Prestamo prestamo = servicioPrestamo.buscarPorNumero(num);
		return ResponseEntity.ok(prestamo);
	}
	
	

}
