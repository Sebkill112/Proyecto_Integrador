package com.proyectoIntegrador.auth;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoIntegrador.entity.Enlace;
import com.proyectoIntegrador.entity.Prestamo;
import com.proyectoIntegrador.entity.Rol;
import com.proyectoIntegrador.entity.Usuario;
import com.proyectoIntegrador.interfaces.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	@PostMapping(value = "login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
		 try {
		        AuthResponse authResponse = authService.login(request);
		        return ResponseEntity.ok(authResponse);
		    } catch (Exception e) {
		        e.printStackTrace(); // Log the exception (consider using a proper logging framework).
		        String errorResponse = "Usuario y/o Contraseña invalida";
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(errorResponse);
		    }
	}

	@PostMapping(value = "register")
	public ResponseEntity<String> register(@RequestBody RegisterRequest request) throws ParseException {
	    
		  boolean emailExists = userRepository.existsByCorreo(request.getCorreo());
		   boolean usernameExists = userRepository.existsByUsername(request.getUsername());
	    
	    if (emailExists) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El Usuario con Correo: " + request.getCorreo() + " ya está registrado");
	    }else if (usernameExists){
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El Usuario con Username: " + request.getUsername() + " ya está registrado");
	    }else {
	    	Usuario user = new Usuario();
		    userRepository.save(user);

		    user.setDni(request.getDni());
			user.setNombre(request.getNombre());
			user.setApellido(request.getApellido());
			user.setCorreo(request.getCorreo());
			user.setUsername(request.getUsername());
			user.setDireccion(request.getDireccion());
			user.setClave(passwordEncoder.encode(request.getPassword()));
			Rol rol = new Rol();
			rol.setCodigo(request.getRol());
			user.setTipoRol(rol);
			
			userRepository.save(user);
		    
		    return ResponseEntity.ok("Usuario registrado correctamente");
	    }

	    
	}
	
	@GetMapping(value = "menus")
	@ResponseBody
	public ResponseEntity<List<Enlace>> listar(@RequestParam int cod){
		List<Enlace> lista = authService.enlacesDelUsuario(cod);
		return ResponseEntity.ok(lista);
	}
}
