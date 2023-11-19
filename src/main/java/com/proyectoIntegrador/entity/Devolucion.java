package com.proyectoIntegrador.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "devolucion")
public class Devolucion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_devolucion")
	private int codigo;
	@Column(name = "num_prestamo")
	private String num_prestamo;
	@Column(name = "num_devolucion")
	private String num_devolucion;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Lima")
	@Column(name = "fecha_devolucion")
	private Date fechaDevolucion;
	
	@Column(name = "observaciones")
	private String observaciones;

	@Column(name = "mora")
	private int mora;
	
	@Column(name = "monto")
	private Double monto;
	
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_usuario")
	private Usuario usuario;

	@JsonManagedReference
	@OneToMany(mappedBy = "devolucion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DevolucionHasLibro> detalleDevolucion;

	

}
