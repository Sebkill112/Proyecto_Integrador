package com.proyectoIntegrador.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibroPorSedeRequest {
	
	 private Libro libro;
	    private int stock;

	    public LibroPorSedeRequest(Libro libro, int stock) {
	        this.libro = libro;
	        this.stock = stock;
	    }

}
