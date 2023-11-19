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
public class DevolucionRequest {

	private Devolucion devolucion;
	private int codSede;
	private List<PrestamoHasLibro> detalleDevolucion;
	private int codigoSede;

}
