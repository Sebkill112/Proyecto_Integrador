package com.proyectoIntegrador.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="libros")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_libro")
	private Integer codigo;
	
	@Column(name="nombre_libro")
	private String nombre;
	
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cod_editorial")
	private Editorial editorial;
	
	@Column(name="autor")
	private String autor;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cod_genero")
	private Genero genero;
	
	@Column(name="anio_edicion")
	private String edicion;
	
	@OneToMany(mappedBy="libroSede")
	@JsonIgnore
	private List<LibrosPorSede> librosSede;
	
	
	@OneToMany(mappedBy="libroEjemplar")
	@JsonIgnore
	private List<Ejemplar> ejemplar;
	
	@Column(name="estado")
	private int estado;

	

	
}
