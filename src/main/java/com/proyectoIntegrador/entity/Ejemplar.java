package com.proyectoIntegrador.entity;

import jakarta.persistence.Column;
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
@Table(name = "ejemplares")
public class Ejemplar {
	
	@Id
	@Column(name = "codigo_ejemplar")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_libro",referencedColumnName = "cod_libro")
	private Libro libroEjemplar;// ASOCI.
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_sede",referencedColumnName = "id_sede")
	private Sede sedeEjemplar;// ASOCI.
	
	@Column(name = "estado")
	private int estado;


}
