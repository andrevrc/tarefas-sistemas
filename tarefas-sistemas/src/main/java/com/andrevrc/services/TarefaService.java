package com.andrevrc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrevrc.domain.StatusTarefa;
import com.andrevrc.domain.Tarefa;
import com.andrevrc.repositories.TarefaRepository;

@RestController
public class TarefaService {
@Autowired
    private TarefaRepository repository;

    @RequestMapping("/tarefas")
    public List<Tarefa> getTarefas() {
        return (List<Tarefa>) repository.findAll();
    }

    @RequestMapping("/tarefas/{status}")
    public List<Tarefa> getTarefasByTitulo(@PathVariable String status) {
        return (List<Tarefa>) repository.findByStatus(StatusTarefa.valueOf(status));
    }

    @RequestMapping("/tarefas/{id}")
    public Optional<Tarefa> getTarefaById(@PathVariable Long id) {
        return repository.findById(id);
    }
    
    @PostMapping("/tarefas")
    public Tarefa novaTarefa(@RequestBody Tarefa novaTarefa) {        
        return repository.save(novaTarefa);
    }

    @PutMapping("/tarefas/{id}")
    public Tarefa atualizarProjeto(@PathVariable Long id, @RequestBody Tarefa t) {
        return repository.findById(id).map(tarefa -> {
            tarefa.setDescricao(t.getDescricao());
            tarefa.setProjeto(t.getProjeto());
            tarefa.setStatus(t.getStatus());
            tarefa.setTitulo(t.getTitulo());
            return repository.save(tarefa);
        }).orElseGet(() -> {
            t.setId(id);
            return repository.save(t);
        });
    }

    @DeleteMapping("/tarefas/{id}")
    public void deleteProjeto(@PathVariable Long id) {
        repository.delete(new Tarefa(id));
    }   
}
