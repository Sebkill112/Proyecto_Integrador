package com.proyectoIntegrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoIntegrador.entity.Editorial;
import com.proyectoIntegrador.interfaces.EditorialRepository;

@Service
public class EditorialService {

	@Autowired
	private EditorialRepository repo;
	
	public List<Editorial> listarTodo(){
		return repo.findAll();
	}
}
