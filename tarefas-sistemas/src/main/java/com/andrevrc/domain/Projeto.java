package com.andrevrc.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Projeto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROJ")
    @SequenceGenerator(name = "SEQ_PROJ", sequenceName = "id_seq_proj", allocationSize = 1)
    private Long id;

    private String nomeProjeto;
    
    private String descricao;

    public Projeto(Long id) {
        this.id = id;
    }
}
