package com.example.Api.SmartSchool.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "disciplinas")
@Table(name = "disciplinas")
public class Disciplina {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    //private Boolean ativo;
    @OneToOne(mappedBy = "disciplinas")
    private Professor professorId;


}
