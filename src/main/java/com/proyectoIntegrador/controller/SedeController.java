package com.proyectoIntegrador.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoIntegrador.entity.Sede;
import com.proyectoIntegrador.service.SedeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/sede")
@RequiredArgsConstructor
public class SedeController {
	
	@Autowired
	private SedeService servicio;
	
	@GetMapping(value = "listado")
	@ResponseBody
	public ResponseEntity<List<Sede>> listar(){
		List<Sede> lista = servicio.listadoSede();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Sede> registrar (@RequestBody Sede bean) {
    	Sede sede=servicio.registrar(bean);
    	return new ResponseEntity<>(sede,HttpStatus.CREATED);
	}
    
    @PutMapping("/actualiza")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaDocente(@RequestBody Sede obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Sede objSalida =  servicio.registrar(obj);
			if (objSalida == null) {
				salida.put("mensaje", "No se actualizó, consulte con el administrador.");
			} else {
				salida.put("mensaje","Se actualizó la sede correctamente.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se actualizó, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}
	
    @DeleteMapping("/elimina/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaDocente(@PathVariable("id") int id) {
		Map<String, Object> salida = new HashMap<>();
		try {
			servicio.eliminaSede(id);
			salida.put("mensaje", "Se elimino la sede correctamente.");
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se eliminó, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}

    
   
    
}
