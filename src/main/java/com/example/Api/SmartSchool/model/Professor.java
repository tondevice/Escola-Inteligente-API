package com.example.Api.SmartSchool.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "professores")
@Table(name = "professores")
public class Professor {

   // @Column(name = "ativo")
    // private Boolean ativo = true;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToOne
    @JoinColumn(name = "disciplinas", referencedColumnName = "id")
    private Disciplina disciplinas;

    public Professor() {}

    public Professor(String nome) {
        this.nome = nome;
    }

}
