package com.gerador.br.domain.repository;

import org.springframework.stereotype.Repository;

import com.gerador.br.api.model.Senha;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SenhaRepository extends JpaRepository<Senha, Long>{

}
