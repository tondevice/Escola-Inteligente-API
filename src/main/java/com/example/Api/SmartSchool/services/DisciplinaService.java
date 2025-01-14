package com.example.Api.SmartSchool.services;

import com.example.Api.SmartSchool.model.Disciplina;
import com.example.Api.SmartSchool.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Disciplina> getAllDisciplinas(){
        return disciplinaRepository.findAll();
    }

    public Disciplina getDisciplinaById(Long id){
        return disciplinaRepository.findById(id).orElse(null);
    }

    public Disciplina criarDisciplina(Disciplina disciplina){
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina atualizarDisciplina(Long id, Disciplina disciplina){
        Disciplina disciplinaExistente = disciplinaRepository.findById(id).orElse(null);
        if (disciplinaExistente != null){
            disciplinaExistente.setNome(disciplina.getNome());
            disciplinaExistente.setProfessorId(disciplina.getProfessorId());
            return disciplinaRepository.save(disciplinaExistente);
        }
        return null;
    }

    public void deletarDisciplina(Long id){
        disciplinaRepository.deleteById(id);
    }
}
