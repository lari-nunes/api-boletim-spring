package com.br.larissa.trabalho.service;

import com.br.larissa.trabalho.model.Disciplina;
import com.br.larissa.trabalho.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Disciplina gravarDisciplina(Disciplina disciplina){
        return disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> listarDisciplinas(){
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> buscarPorId(Long id){
        return disciplinaRepository.findById(id);
    }

    public Optional<Disciplina> atualizaDisciplinaId(Long id){
        return disciplinaRepository.findById(id);
    }

    public void deletarDisciplina(Optional<Disciplina> disciplina){
        disciplinaRepository.delete(disciplina.get());
    }
}
