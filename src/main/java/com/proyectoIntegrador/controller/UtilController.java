package com.proyectoIntegrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoIntegrador.entity.Editorial;
import com.proyectoIntegrador.entity.Genero;
import com.proyectoIntegrador.service.EditorialService;
import com.proyectoIntegrador.service.GeneroService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/util")
@RequiredArgsConstructor
public class UtilController {

	
	@Autowired
	private GeneroService serGenero;
	
	@Autowired
	private EditorialService serEditorial;
	
	@GetMapping(value = "editorial")
	@ResponseBody
	public ResponseEntity<List<Editorial>> listarEditorial(){
		List<Editorial> lista = serEditorial.listarTodo();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping(value = "genero")
	@ResponseBody
	public ResponseEntity<List<Genero>> listarGenero(){
		List<Genero> lista = serGenero.listarTodo();
		return ResponseEntity.ok(lista);
	}
	
}
