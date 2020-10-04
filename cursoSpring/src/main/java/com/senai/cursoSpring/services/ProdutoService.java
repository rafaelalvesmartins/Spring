package com.senai.cursoSpring.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senai.cursoSpring.domain.Categoria;
import com.senai.cursoSpring.domain.Produto;
import com.senai.cursoSpring.repositories.CategoriaRepository;
import com.senai.cursoSpring.repositories.ProdutoRepository;
import com.senai.cursoSpring.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Optional<Produto> find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Produto.class.getName());
		}
		return obj;
	}
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
	
		Pageable pageable = PageRequest.of(page, linesPerPage);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias,pageable);	
	
	}
}
