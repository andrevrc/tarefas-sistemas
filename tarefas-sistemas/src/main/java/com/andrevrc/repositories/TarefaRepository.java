package com.andrevrc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.andrevrc.domain.Projeto;
import com.andrevrc.domain.StatusTarefa;
import com.andrevrc.domain.Tarefa;

public interface TarefaRepository extends CrudRepository<Tarefa, Long> {
    public List<Tarefa> findByProjeto(Projeto projeto);

    public List<Tarefa> findByStatus(StatusTarefa status);
}
