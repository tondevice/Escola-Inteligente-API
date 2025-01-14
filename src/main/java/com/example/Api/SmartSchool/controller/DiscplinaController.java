package com.example.Api.SmartSchool.controller;

import com.example.Api.SmartSchool.model.Disciplina;
import com.example.Api.SmartSchool.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disciplinas")
@CrossOrigin("*")

public class DiscplinaController {

    private DisciplinaService disciplinaService;

    @Autowired
    public void DisciplinaController(DisciplinaService disciplinaService){
        this.disciplinaService = disciplinaService;
    }
    @GetMapping("")
    public List<Disciplina> getAllDisciplinas(){
        return disciplinaService.getAllDisciplinas();
    }
    @GetMapping("/{id}")
    public Disciplina getDisciplinaById(@PathVariable("id") Long id) {
        return disciplinaService.getDisciplinaById(id);
    }
    @PostMapping("")
    public Disciplina criarDisciplina(@RequestBody Disciplina disciplina){
        return disciplinaService.criarDisciplina(disciplina);
    }
    @PutMapping("/{id}")
    public Disciplina atualizarDisciplina(@PathVariable("id") Long id, @RequestBody Disciplina disciplina){
        return disciplinaService.atualizarDisciplina(id, disciplina);
    }
    @DeleteMapping("/{id}")
    public void deletarDisciplina(@PathVariable("id") Long id){
        disciplinaService.deletarDisciplina(id);
    }
}
