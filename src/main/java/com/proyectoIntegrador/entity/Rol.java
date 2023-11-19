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
@Table(name = "rol")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_rol")
	private Integer codigo;
	@Column(name = "descripcion_rol")
	private String descripcion;

	// relación UNO A MUCHOS
	@OneToMany(mappedBy = "tipoRol") // NOMBRE DE LA ASOCIACION
	@JsonIgnore
	private List<Usuario> listaUsuarios;
	
	@JsonIgnore
	@OneToMany(mappedBy = "rol")
	private List<RolEnlace> listaRolEnlace;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<RolEnlace> getListaRolEnlace() {
		return listaRolEnlace;
	}

	public void setListaRolEnlace(List<RolEnlace> listaRolEnlace) {
		this.listaRolEnlace = listaRolEnlace;
	}

}
