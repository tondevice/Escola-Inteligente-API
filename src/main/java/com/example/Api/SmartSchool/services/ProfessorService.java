package com.example.Api.SmartSchool.services;

import com.example.Api.SmartSchool.model.Professor;
import com.example.Api.SmartSchool.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> getAllProfessores() {
        return professorRepository.findAll();
    }
    public Professor getProfessorById(Long id){
        return professorRepository.findById(id).orElse(null);
    }
    public Professor criarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }
    public Professor atualizarProfessor(Long id, Professor professor){
        Professor professorExistente = professorRepository.findById(id).orElse(null);
        if (professorExistente != null){
            professorExistente.setNome(professor.getNome());
            professorExistente.setDisciplinas(professor.getDisciplinas());
            return professorRepository.save(professorExistente);
        }
        return null;
    }
    public void deletarProfessor(Long id){
        professorRepository.deleteById(id);
    }


    }
