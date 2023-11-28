package com.br.larissa.trabalho.service;

import com.br.larissa.trabalho.model.Aluno;
import com.br.larissa.trabalho.model.Curso;
import com.br.larissa.trabalho.repository.AlunoRepository;
import com.br.larissa.trabalho.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso gravarCurso(Curso curso){
        return cursoRepository.save(curso);
    }

    public List<Curso> listarCursos(){
        return cursoRepository.findAll();
    }

    public Optional<Curso> buscarPorId(Long matricula){
        return cursoRepository.findById(matricula);
    }

    public void deletarCurso(Optional<Curso> curso){
        cursoRepository.delete(curso.get());
    }
}
