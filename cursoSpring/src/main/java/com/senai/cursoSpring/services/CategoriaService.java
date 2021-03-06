package com.senai.cursoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.cursoSpring.domain.Categoria;
import com.senai.cursoSpring.repositories.CategoriaRepository;
import com.senai.cursoSpring.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		
		
	}
	
	public List<Categoria> retornaTudo() {
		List<Categoria> obj = repo.findAll();
		return obj;
	}

}
