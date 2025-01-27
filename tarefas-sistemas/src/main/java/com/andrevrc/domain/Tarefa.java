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
public class Tarefa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TASK")
    @SequenceGenerator(name = "SEQ_TASK", sequenceName = "id_seq_task", allocationSize = 1)
    private Long id;
    
    private String titulo;
    private StatusTarefa status;
    private String descricao;
    private Projeto projeto;

    public Tarefa(Long id) {
        this.id = id;
    }
}
