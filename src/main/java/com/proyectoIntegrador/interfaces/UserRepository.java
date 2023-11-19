package com.proyectoIntegrador.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectoIntegrador.entity.Enlace;
import com.proyectoIntegrador.entity.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Integer>{

	Optional<Usuario> findByUsername(String user);
	
	 boolean existsByCorreo(String correo);
	 
	 boolean existsByUsername(String username);
	 
	 @Query("select e from RolEnlace re join re.enlace e where re.rol.codigo=?1")
		public List<Enlace>traerEnlacesDelUsuario(int codigoRol);
}
