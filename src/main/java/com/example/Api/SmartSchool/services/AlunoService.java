package com.example.Api.SmartSchool.services;

import com.example.Api.SmartSchool.model.Aluno;
import com.example.Api.SmartSchool.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }
    public Aluno getAlunoById(Long id){
        return alunoRepository.findById(id).orElse(null);
    }
    public Aluno criarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
    public Aluno atualizarAluno(Long id, Aluno aluno){
        Aluno alunoExistente = alunoRepository.findById(id).orElse(null);
        if (alunoExistente != null){
            alunoExistente.setNome(aluno.getNome());
            alunoExistente.setSobrenome(aluno.getSobrenome());
            alunoExistente.setTelefone(aluno.getTelefone());
            return alunoRepository.save(alunoExistente);
        }
        return null;
    }
    public void deletarAluno(Long id){
        alunoRepository.deleteById(id);
    }

    public void atualizarAlunoComEstadoInativo(Aluno aluno) {
        aluno.setAtivo(false);
        alunoRepository.save(aluno);
    }

    public void atualizarAlunoComEstadoAtivo(Aluno aluno) {
        aluno.setAtivo(true);
        alunoRepository.save(aluno);
    }

    public void toggleAtivo(Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        alunoOptional.ifPresent(aluno -> {
            aluno.setAtivo(!aluno.isAtivo());
            alunoRepository.save(aluno);
        });
    }
}
