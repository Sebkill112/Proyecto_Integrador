package com.proyectoIntegrador.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "detalle_devolucion")
public class DevolucionHasLibro {

	@Id
	@Column(name = "detalle_devolucion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="cod_devolucion",referencedColumnName = "cod_devolucion")
	private Devolucion devolucion;// ASOCI.


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_libro",referencedColumnName = "cod_libro")
	private Libro libro;// ASOCI.
	
	@Column(name="cod_ejemplar")
	private Integer codigoEjemplar;
	



}
