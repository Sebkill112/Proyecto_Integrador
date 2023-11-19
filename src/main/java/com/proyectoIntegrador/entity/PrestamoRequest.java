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
public class PrestamoRequest {
	
	 private Prestamo prestamo;
	   private List<Libro> detallePrestamo;

}
