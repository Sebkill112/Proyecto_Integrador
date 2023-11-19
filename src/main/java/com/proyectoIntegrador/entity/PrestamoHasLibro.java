package com.proyectoIntegrador.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "detalle_prestamo")
public class PrestamoHasLibro  {
	
	@Id
	@Column(name = "detalle_prestamo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
			@ManyToOne(fetch = FetchType.EAGER)
			@JsonBackReference
			@JoinColumn(name="cod_prestamo",referencedColumnName = "cod_prestamo")
			private Prestamo prestamo;
	
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="cod_libro",referencedColumnName = "cod_libro")
		private Libro libro;
		
		
		@Column(name = "cod_ejemplar")
		private Integer ejemplar;
		
		@Column(name = "estado")
		private String estado;

}
