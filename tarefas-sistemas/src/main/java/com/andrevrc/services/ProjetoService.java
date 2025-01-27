package com.andrevrc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.andrevrc.domain.Projeto;
import com.andrevrc.repositories.ProjetoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class ProjetoService {

    @Autowired
    private ProjetoRepository repository;

    @RequestMapping("/projetos")
    public List<Projeto> getProjetos() {
        return (List<Projeto>) repository.findAll();
    }

    @RequestMapping("/projetos/{nome}")
    public List<Projeto> getProjetosByNome(@PathVariable String nome) {
        return (List<Projeto>) repository.findByNomeProjeto(nome);
    }

    @RequestMapping("/projetos/{id}")
    public Optional<Projeto> getProjetoById(@PathVariable Long id) {
        return repository.findById(id);
    }
    
    @PostMapping("/projetos")
    public Projeto novoProjeto(@RequestBody Projeto novoProjeto) {        
        return repository.save(novoProjeto);
    }

    @PutMapping("/projetos/{id}")
    public Projeto atualizarProjeto(@PathVariable Long id, @RequestBody Projeto p) {
        return repository.findById(id).map(projeto -> {
            projeto.setDescricao(p.getDescricao());
            projeto.setNomeProjeto(p.getNomeProjeto());
            return repository.save(projeto);
        }).orElseGet(() -> {
            p.setId(id);
            return repository.save(p);
        });
    }

    @DeleteMapping("/projetos/{id}")
    public void deleteProjeto(@PathVariable Long id) {
        repository.delete(new Projeto(id));
    }   
    
}
