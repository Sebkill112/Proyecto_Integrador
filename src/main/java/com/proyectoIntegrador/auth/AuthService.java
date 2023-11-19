package com.proyectoIntegrador.auth;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyectoIntegrador.entity.Enlace;
import com.proyectoIntegrador.entity.Rol;
import com.proyectoIntegrador.entity.Usuario;
import com.proyectoIntegrador.interfaces.UserRepository;
import com.proyectoIntegrador.jwt.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final UserRepository userRepository;
	private final JwtService jwtService;
	 private final PasswordEncoder passwordEncoder;
	 private final AuthenticationManager authenticationManager;
	 
	 
	 public List<Enlace> enlacesDelUsuario(int rol){
			return userRepository.traerEnlacesDelUsuario(rol);
		}
	 

	public AuthResponse login(LoginRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Usuario usu = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .codigo(usu.getCodigo())
            .username(usu.getUsername())
            .rol(usu.getTipoRol())
            .build();

	}
	
	public String register(RegisterRequest request) throws ParseException {
		String mensaje= "";
		
		Usuario existente = null;
		
		
		if(userRepository.existsByCorreo(request.getCorreo())) {
			mensaje = "El Usuario con Correo: " + request.getCorreo() + " ya esta registrado";
		}else {
			Usuario user = new Usuario();
			
			user.setDni(request.getDni());
			user.setNombre(request.getNombre());
			user.setApellido(request.getApellido());
			user.setCorreo(request.getCorreo());
			user.setUsername(request.getUsername());
			user.setDireccion(request.getDireccion());
			user.setClave(passwordEncoder.encode( request.getPassword()));
			Rol rol = new Rol();
			rol.setCodigo(request.getRol());
			user.setTipoRol(rol);
			
			userRepository.save(user);
			
			mensaje = "Usuario registrado correctamente";
		}
		
		
		return mensaje;
	}
}
