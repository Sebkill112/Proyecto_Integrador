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
@Table(name = "sede")
public class Sede {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sede")
	private Integer codigo;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "contacto_sede")
	private String contactoSede;

	@OneToMany(mappedBy = "sede")
	@JsonIgnore
	private List<Prestamo> listaPrestamo;

	@OneToMany(mappedBy = "sedeLibro")
	@JsonIgnore
	private List<LibrosPorSede> sedesLibro;

	@OneToMany(mappedBy = "sedeEjemplar")
	@JsonIgnore
	private List<Ejemplar> sedeEjmeplar;

	@Column(name = "estado")
	private int estado;

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getContactoSede() {
		return contactoSede;
	}

	public void setContactoSede(String contactoSede) {
		this.contactoSede = contactoSede;
	}

	public List<Prestamo> getListaPrestamo() {
		return listaPrestamo;
	}

	public void setListaPrestamo(List<Prestamo> listaPrestamo) {
		this.listaPrestamo = listaPrestamo;
	}

	public List<LibrosPorSede> getSedesLibro() {
		return sedesLibro;
	}

	public void setSedesLibro(List<LibrosPorSede> sedesLibro) {
		this.sedesLibro = sedesLibro;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<Ejemplar> getSedeEjmeplar() {
		return sedeEjmeplar;
	}

	public void setSedeEjmeplar(List<Ejemplar> sedeEjmeplar) {
		this.sedeEjmeplar = sedeEjmeplar;
	}

}
