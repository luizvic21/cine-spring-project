package br.com.edward.restfull.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.restfull.model.CategoriaModel;
import br.com.edward.restfull.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@PostMapping("/cadastrar")
	public CategoriaModel cadastrar(@RequestBody CategoriaModel model) {
		return new CategoriaModel(service.cadastrar(model));
	}
	
	@GetMapping("/listar")
	public List<CategoriaModel> listar() {
		return service.listar().stream().map(CategoriaModel::new).collect(Collectors.toList());
	}
	
	@DeleteMapping("/remover")
	public CategoriaModel remover(@RequestParam Long id) {
		return new CategoriaModel((service.remover(id)));
	}
}