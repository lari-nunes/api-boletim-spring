package com.br.larissa.trabalho.service;

import com.br.larissa.trabalho.model.Aluno;
import com.br.larissa.trabalho.model.AlunoCurso;
import com.br.larissa.trabalho.repository.AlunoCursoRepository;
import com.br.larissa.trabalho.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoCursoService {

    @Autowired
    private AlunoCursoRepository alunoCursoRepository;

    public AlunoCurso gravarAlunoCurso(AlunoCurso alunoCurso){
        return alunoCursoRepository.save(alunoCurso);
    }

    public List<AlunoCurso> listarAlunoCurso(){
        return alunoCursoRepository.findAll();
    }

    public Optional<AlunoCurso> buscarPorId(Long id){
        return alunoCursoRepository.findById(id);
    }

    public Optional<AlunoCurso> atualizaAlunoCurso(Long id){
        return alunoCursoRepository.findById(id);
    }

    public void deletarAlunoCurso(Optional<AlunoCurso> alunoCurso){
        alunoCursoRepository.delete(alunoCurso.get());
    }
}
