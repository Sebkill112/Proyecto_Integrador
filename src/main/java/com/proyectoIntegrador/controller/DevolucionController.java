package com.proyectoIntegrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoIntegrador.entity.Devolucion;
import com.proyectoIntegrador.entity.DevolucionHasLibro;
import com.proyectoIntegrador.entity.DevolucionRequest;
import com.proyectoIntegrador.entity.PrestamoHasLibro;
import com.proyectoIntegrador.service.DevolucionHasLibroService;
import com.proyectoIntegrador.service.DevolucionService;
import com.proyectoIntegrador.service.LibrosPorSedeService;
import com.proyectoIntegrador.service.prestamoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/devolucion")
@RequiredArgsConstructor
public class DevolucionController {

	@Autowired
	private DevolucionService serDevolucion;

	@Autowired
	private prestamoService serPrestamo;

	@Autowired
	private DevolucionHasLibroService serDetalle;

	@Autowired
	private LibrosPorSedeService serLibrosPorSede;

	@GetMapping(value = "listado")
	@ResponseBody
	public ResponseEntity<List<Devolucion>> listar() {
		List<Devolucion> lista = serDevolucion.listarDevolucion();
		return ResponseEntity.ok(lista);
	}

	@PostMapping(value = "devolver/{codPres}")
	@ResponseBody
	@Transactional
	public ResponseEntity<String> registrarDevolucion(@PathVariable("codPres") int codPre,
			@RequestBody DevolucionRequest devolucionRequest) {
		try {
			Devolucion devolucion = devolucionRequest.getDevolucion();
			Devolucion devolucionGuardado = serDevolucion.registrar(devolucion);
			List<PrestamoHasLibro> libros = devolucionRequest.getDetalleDevolucion();

			for (int i = 0; i < libros.size(); i++) {
				DevolucionHasLibro detalle = new DevolucionHasLibro();
				detalle.setDevolucion(devolucionGuardado);
				detalle.setLibro(libros.get(i).getLibro());
				detalle.setCodigoEjemplar(libros.get(i).getEjemplar());
				serDetalle.grabar(detalle);

			}

			for (int i = 0; i < libros.size(); i++) {

				serDevolucion.DevolucionActualizarEstadoYStock(codPre, libros.get(i).getEjemplar(),
						libros.get(i).getLibro().getCodigo(), devolucionRequest.getCodigoSede());
				
			}

			serPrestamo.ActualizarEstado("Devuelto", devolucionGuardado.getNum_prestamo());

			return ResponseEntity.ok("Devolucion registrado exitosamente.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al registrar el préstamo: " + e.getMessage());
		}
	}

	@GetMapping(value = "codigo")
	@ResponseBody
	public ResponseEntity<String> correlativo() {
		String codigo = serDevolucion.GenerarCodigo();

		return ResponseEntity.ok(codigo);
	}

}
