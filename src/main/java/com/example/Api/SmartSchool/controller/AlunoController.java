package com.example.Api.SmartSchool.controller;

import com.example.Api.SmartSchool.model.Aluno;
import com.example.Api.SmartSchool.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin("*")
public class AlunoController {
    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("")
    public List<Aluno> getAllAlunos() {
        return alunoService.getAllAlunos();
    }

    @GetMapping("/{id}")
    public Aluno getAlunoById(@PathVariable("id") Long id) {
        return alunoService.getAlunoById(id);
    }

    @PostMapping("")
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoService.criarAluno(aluno);
    }

    @PutMapping("/toggle-ativo/{id}")
    public ResponseEntity<Void> toggleAtivarDesativarAluno(@PathVariable("id") Long id) {
        alunoService.toggleAtivo(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable("id") Long id) {
        Optional<Aluno> alunoOptional = Optional.ofNullable(alunoService.getAlunoById(id));

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            aluno.setAtivo(false);

            alunoService.atualizarAlunoComEstadoInativo(aluno);

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
