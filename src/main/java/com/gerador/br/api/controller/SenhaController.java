package com.gerador.br.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerador.br.api.model.Senha;
import com.gerador.br.api.model.SenhaModel;
import com.gerador.br.api.service.SenhaService;
import com.gerador.br.domain.repository.SenhaRepository;

@RestController
@RequestMapping("/senha")
public class SenhaController {
	
	@Autowired
	private SenhaRepository senhaRepository;
	
	@Autowired
	private SenhaService senhaService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/gerar/{preferencial}")
	public List<SenhaModel> gerarSenha(@PathVariable Boolean preferencial) {
		return toCollection(senhaService.gerar(preferencial));
	}
	
	private SenhaModel toModel(Senha senha) {
		return modelMapper.map(senha, SenhaModel.class);
	}
	
	private List<SenhaModel> toCollection(List<Senha> senhas) {
		return senhas.stream()
				.map(senha -> toModel(senha))
				.collect(Collectors.toList());
	}
}
