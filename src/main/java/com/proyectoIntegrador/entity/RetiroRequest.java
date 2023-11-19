package com.proyectoIntegrador.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RetiroRequest {

	private String estado;
	private int codSede;
	private String numPrestamo;
	private String observacion;
	
	 private List<Ejemplar> ejemplares;
	
}
