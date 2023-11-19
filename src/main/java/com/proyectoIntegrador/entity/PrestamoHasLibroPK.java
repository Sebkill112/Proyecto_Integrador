package com.proyectoIntegrador.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class PrestamoHasLibroPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "cod_prestamo")
	private int codigoPrestamo;
	@Column(name = "cod_libro")
	private int codigoLibro;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoLibro;
		result = prime * result + codigoPrestamo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrestamoHasLibroPK other = (PrestamoHasLibroPK) obj;
		if (codigoLibro != other.codigoLibro)
			return false;
		if (codigoPrestamo != other.codigoPrestamo)
			return false;
		return true;
	}

	

	
}
