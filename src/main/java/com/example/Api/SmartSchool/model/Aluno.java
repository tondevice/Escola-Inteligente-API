package com.example.Api.SmartSchool.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "alunos")
@Table(name = "alunos")
public class Aluno {

    @Column(name = "ativo")
    private Boolean ativo = true;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String telefone;
    

    public boolean isAtivo() {
        return this.ativo != null && this.ativo;
    }
}

