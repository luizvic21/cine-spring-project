package br.com.edward.restfull.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.edward.restfull.model.SessaoModel;
import br.com.edward.restfull.service.SessaoService;
import br.com.edward.restfull.view.SessaoView;

@RestController
@RequestMapping("/sessao")
public class SessaoController {
	
	@Autowired
	private SessaoService service;
	
	@PostMapping("/cadastrar")
	public SessaoView cadastrar(@Valid @RequestBody SessaoModel model) {
		return new SessaoView(new SessaoModel(service.cadastrar(model)));
	}
	
	@PostMapping("/cadastrar_semana")
	public void cadastrarSemana(@Valid @RequestBody SessaoModel model) {
		/*returnnew SessaoView(new SessaoModel(*/service.cadastarSemana(model); 
	}
	
	@GetMapping("/listar")
	public List<SessaoView> listar() {
		return service.listar().stream().map(SessaoModel::new).map(SessaoView::new).collect(Collectors.toList());
	}
	
	@DeleteMapping("/remover")
	public SessaoModel remover(@RequestParam Long id) {	
		return new SessaoModel((service.remover(id)));
	}
	
}
