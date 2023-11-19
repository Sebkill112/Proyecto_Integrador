package com.proyectoIntegrador.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="editorial")
public class Editorial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_editorial")
	private Integer codigo;
	
	@Column(name="nombre_editorial")
	private String nombre;
	
	@OneToMany(mappedBy="editorial")
	@JsonIgnore
	private List<Libro> listaLibro;
	
	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Libro> getListaLibro() {
		return listaLibro;
	}

	public void setListaLibro(List<Libro> listaLibro) {
		this.listaLibro = listaLibro;
	}
	
	
	
}
