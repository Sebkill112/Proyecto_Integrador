package com.proyectoIntegrador.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "usuario", uniqueConstraints = { @UniqueConstraint(columnNames = { "correo" }) })
public class Usuario implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_usuario")
	private Integer codigo;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "dni")
	private String dni;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "correo")
	private String correo;
	@Column(name = "username")
	private String username;
	@Column(name = "clave")
	private String clave;

	// BI-DIRECCIONAL
	// MUCHOS A UNO
	@ManyToOne
	@JoinColumn(name = "cod_rol")
	private Rol tipoRol;// "tipoRol"---> ASOCIACION ENTRE ENTIDADES

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Prestamo> listaPrestamos;

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Devolucion> listaDevolucion;

	public List<Prestamo> getListaPrestamos() {
		return listaPrestamos;
	}

	public void setListaPrestamos(List<Prestamo> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Rol getTipoRol() {
		return tipoRol;
	}

	public void setTipoRol(Rol tipoRol) {
		this.tipoRol = tipoRol;
	}

	public List<Devolucion> getListaDevolucion() {
		return listaDevolucion;
	}

	public void setListaDevolucion(List<Devolucion> listaDevolucion) {
		this.listaDevolucion = listaDevolucion;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority(((tipoRol.getDescripcion()))));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return clave;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
