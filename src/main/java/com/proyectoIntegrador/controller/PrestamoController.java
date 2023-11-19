package com.proyectoIntegrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoIntegrador.entity.Ejemplar;
import com.proyectoIntegrador.entity.Libro;
import com.proyectoIntegrador.entity.Prestamo;
import com.proyectoIntegrador.entity.PrestamoHasLibro;
import com.proyectoIntegrador.entity.PrestamoRequest;
import com.proyectoIntegrador.entity.RetiroRequest;
import com.proyectoIntegrador.service.LibrosPorSedeService;
import com.proyectoIntegrador.service.PrestamoHasLibroService;
import com.proyectoIntegrador.service.prestamoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/prestamo")
@RequiredArgsConstructor
public class PrestamoController {
	
	
	@Autowired
	private prestamoService servicio;
	
	@Autowired
	private PrestamoHasLibroService servicioDetalle;
	
	@Autowired
	private LibrosPorSedeService servicioLibroPorSede;
	
	@PostMapping(value = "registro")
	@ResponseBody
	@Transactional
	 public ResponseEntity<String> registrarPrestamo(@RequestBody PrestamoRequest prestamoRequest) {
        try {
            // Create and save the Prestamo entity
            Prestamo prestamo = prestamoRequest.getPrestamo();
            Prestamo prestamoGuardado = servicio.registrar(prestamo);
            List<Libro> libros = prestamoRequest.getDetallePrestamo();
            // Associate PrestamoHasLibro details with the Prestamo and save them
 
            for (int i=0; i < libros.size(); i++) {
                PrestamoHasLibro detalle = new PrestamoHasLibro();
                detalle.setPrestamo(prestamoGuardado);
                detalle.setLibro(libros.get(i));
                servicioDetalle.grabar(detalle);
                
            }
            
            return ResponseEntity.ok("Préstamo registrado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar el préstamo: " + e.getMessage());
        }
	}
	
	
	@GetMapping(value = "listado")
	@ResponseBody
	public ResponseEntity<List<Prestamo>> listar(){
		List<Prestamo> lista = servicio.listarTodo();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping(value = "listarPorEstado/{est}")
	@ResponseBody
	public ResponseEntity<List<Prestamo>> listarPorEstado(@PathVariable("est")String est){
		List<Prestamo> lista = servicio.listarPorEstado(est);
		return ResponseEntity.ok(lista);
	}
	
	@PutMapping(value = "retiro/{cod}")
	@ResponseBody
	@Transactional
	 public ResponseEntity<String> retirarPrestamo(@PathVariable("cod")int codPrest,@RequestBody RetiroRequest retiroRequest) {
        try {
        	
        	
        	
        	servicio.ActualizarObservacion(retiroRequest.getObservacion(), retiroRequest.getNumPrestamo());
        	servicio.ActualizarEstado(retiroRequest.getEstado(), retiroRequest.getNumPrestamo());
        	
        	List<Ejemplar> ejemplares = retiroRequest.getEjemplares();
 
            for (int i=0; i < ejemplares.size(); i++) {
               servicio.RetiroActulizaEstadoStock(codPrest, ejemplares.get(i).getCodigo(), 
            		   ejemplares.get(i).getLibroEjemplar().getCodigo(), retiroRequest.getCodSede());
                
            }
            
            return ResponseEntity.ok("Préstamo retirado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar el préstamo: " + e.getMessage());
        }
	}
	
	@GetMapping(value = "codigo")
	@ResponseBody
	public ResponseEntity<String> correlativo(){
		String codigo = servicio.GenerarCodigo();
		
		return ResponseEntity.ok(codigo);
	}
	
	@GetMapping(value = "historial/{cod}")
	@ResponseBody
	public ResponseEntity<List<Prestamo>> listar(@PathVariable("cod")int codUser){
		List<Prestamo> lista = servicio.buscarPorUsuario(codUser);
		return ResponseEntity.ok(lista);
	}
	
}
