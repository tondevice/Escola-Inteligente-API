package com.example.Api.SmartSchool.controller;

import com.example.Api.SmartSchool.model.Professor;
import com.example.Api.SmartSchool.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professores")
@CrossOrigin("*")
public class ProfessorController {

    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }
    @GetMapping("")
    public List<Professor> getAllProfessores(){
        return professorService.getAllProfessores();
    }
    @GetMapping("/{id}")
    public Professor getProfessorById(@PathVariable("id") Long id){
        return professorService.getProfessorById(id); }
    @PostMapping("")
    public Professor criarProfessor(@RequestBody Professor professor){
        return professorService.criarProfessor(professor);
    }
    @PutMapping("/{id}")
    public Professor atualizarProfessor(@PathVariable("id") Long id, @RequestBody Professor professor){
        return professorService.atualizarProfessor(id, professor);
    }
    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable("id") Long id){
        professorService.deletarProfessor(id);
    }
}
