package com.proyectoIntegrador.auth;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	String dni;
	String nombre;
	String apellido;
	String direccion;
	String fecha;
	String correo;
	String username;
	String password;
	Integer rol;


}
