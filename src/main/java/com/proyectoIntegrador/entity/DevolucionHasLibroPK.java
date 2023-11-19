package com.proyectoIntegrador.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;

public class DevolucionHasLibroPK implements Serializable {

	@Column(name = "cod_devolucion")
	private int codigoDevolucion;
	@Column(name = "cod_libro")
	private int codigoLibro;

	public int getCodigoDevolucion() {
		return codigoDevolucion;
	}

	public void setCodigoDevolucion(int codigoPrestamo) {
		this.codigoDevolucion = codigoPrestamo;
	}

	public int getCodigoLibro() {
		return codigoLibro;
	}

	public void setCodigoLibro(int codigoLibro) {
		this.codigoLibro = codigoLibro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoLibro;
		result = prime * result + codigoDevolucion;
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
		DevolucionHasLibroPK other = (DevolucionHasLibroPK) obj;
		if (codigoLibro != other.codigoLibro)
			return false;
		if (codigoDevolucion != other.codigoDevolucion)
			return false;
		return true;
	}
	
	

}
