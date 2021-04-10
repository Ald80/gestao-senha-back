package com.gerador.br.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerador.br.api.model.Senha;
import com.gerador.br.api.model.Tipo;
import com.gerador.br.domain.repository.SenhaRepository;
import com.gerador.br.domain.repository.TipoRepository;

@Service
public class SenhaService {
	
	@Autowired
	private SenhaRepository senhaRepository;
	
	@Autowired
	private TipoRepository tipoRepository;
	
	public List<Senha> gerar(Boolean preferencial) {
		Senha senha = new Senha();
		Tipo tipo = null;
		if (preferencial) 
			tipo = tipoRepository.findById(2L).orElseThrow();
		else 
			tipo = tipoRepository.findById(1L).orElseThrow();

			senha.setTipo(tipo);
			
//		} else {
//			if (preferencial) {
//				tipo = tipoRepository.findById(2L).orElseThrow();
//				int valorFormato =  Integer.parseInt((senhas.get(senhas.size() - 1).getFormato())) + 1;
//				String valor = null;
//				if (valorFormato  > 9) {
//					valor = String.valueOf(valorFormato);
//				} else {
//					valor = String.valueOf("0"+valorFormato);
//				}
				
//				senha.setTipo(tipo);
//			} else {
//				tipo = tipoRepository.findById(1L).orElseThrow();
//				int valorFormato =  Integer.parseInt((senhas.get(senhas.size() - 1).getFormato())) + 1;
//				String valor = null;
				
//				if (valorFormato  > 9) {
//					valor = String.valueOf(valorFormato);
//				} else {
//					valor = String.valueOf("0"+valorFormato);
//				}
				
//				senha.setFormato(valor);
//				senha.setTipo(tipo);
//			}
//		}
//		senhas.add(senha);
		return null;
	}
	
	public List<Senha> listar() {
		return senhaRepository.findAll();
	}
	
	public Senha persistSenha(Senha senha) {
		return senhaRepository.save(senha);
	}
	
	public Senha validarGeracao() {
		return null;
	}
}