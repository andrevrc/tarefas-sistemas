package com.andrevrc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.andrevrc.domain.Projeto;

public interface ProjetoRepository extends CrudRepository<Projeto, Long> {
    public List<Projeto> findByNomeProjeto(String nome);
}
